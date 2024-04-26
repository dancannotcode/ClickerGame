package com.example.testing.ui.customizationTab;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.testing.R;
import com.example.testing.saveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import android.net.Uri;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomizationFragment extends Fragment{

    ImageView enemy;
    ImageView enemy2;
    ImageView currentEnemy;
    Button enemy1Button;
    Button enemy2Button;
    EditText nameField;
    int currentCustomization = 0;

    /**
     * Everything that is started when the page is opened
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return the fragment
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View CustomizationFragment = inflater.inflate(R.layout.fragment_customization, container, false);
        enemy = CustomizationFragment.findViewById(R.id.enemy);
        enemy2 = CustomizationFragment.findViewById(R.id.enemy2);
        enemy1Button = CustomizationFragment.findViewById(R.id.enemy1Button);
        enemy2Button = CustomizationFragment.findViewById(R.id.enemy2Button);
        currentEnemy = enemy;
        enemy1Button.setBackgroundColor(Color.LTGRAY);
        nameField = CustomizationFragment.findViewById(R.id.virus_name);
        return CustomizationFragment;

    }

    /**
     * Assigned all the buttons to their various purposes.
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        view.findViewById(R.id.black_button).setOnClickListener(view18 -> {
            int color = Color.BLACK;
            changeColor(color);
        });
        view.findViewById(R.id.purple_button).setOnClickListener(view17 -> {
            int color = Color.MAGENTA;
            changeColor(color);
        });
        view.findViewById(R.id.yellow_button).setOnClickListener(view16 -> {
            int color = Color.YELLOW;
            changeColor(color);
        });
        view.findViewById(R.id.green_button).setOnClickListener(view15 -> {
            int color = Color.GREEN;
            changeColor(color);
        });
        view.findViewById(R.id.enemy1Button).setOnClickListener(view14 -> {
            enemy1Button.setBackgroundColor(Color.LTGRAY);
            enemy2Button.setBackgroundColor(Color.TRANSPARENT);
            currentEnemy = enemy;
        });
        view.findViewById(R.id.enemy2Button).setOnClickListener(view13 -> {
            enemy2Button.setBackgroundColor(Color.LTGRAY);
            enemy1Button.setBackgroundColor(Color.TRANSPARENT);
            currentEnemy = enemy2;
        });
        view.findViewById(R.id.blue_button).setOnClickListener(view12 -> {
            int color = Color.BLUE;
            changeColor(color);
        });
        view.findViewById(R.id.red_button).setOnClickListener(view1 -> {
            int color = Color.RED;
            changeColor(color);
        });
        view.findViewById(R.id.submit_Button).setOnClickListener(v -> {
            saveData saveData = new saveData();
            String userId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
            String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            assert userEmail != null;

            String virusName = nameField.getText().toString();

            saveData.setVirusNamePart(virusName, currentCustomization);
            currentCustomization++;
            saveData.setCurrentCustomizations(currentCustomization);
            Map<String, Object> virusData = new HashMap<>();
            virusData.put("virusName", FieldValue.arrayUnion(virusName));

            FirebaseFirestore.getInstance().collection(userEmail).document(userId).update(virusData)// Set the virus data in Firestore
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    // Data successfully added
                                    currentCustomization++;
                                    saveData.setCurrentCustomizations(currentCustomization);
                                    NavHostFragment.findNavController(CustomizationFragment.this)
                                            .navigate(R.id.action_navigation_notifications_to_navigation_customizationcheck);
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                }
                            });
        });
    }

    /**
     * Class Responsible for changing the color of the enemy
     * @param color The color that will be set for the enemy
     */
    private void changeColor(int color) {
        currentEnemy.setColorFilter(color);

        String userId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        assert userEmail != null;

        // Create a map to store the enemy image
        Map<String, Object> enemyArr = new HashMap<>();
        enemyArr.put("enemyImage", FieldValue.arrayUnion(currentEnemy.toString()));

        FirebaseFirestore.getInstance().collection(userEmail).document(userId).update(enemyArr)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                }

                );

    }
}