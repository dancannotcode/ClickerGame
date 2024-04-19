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
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.testing.R;
import com.example.testing.databinding.FragmentCustomizationBinding;
import com.example.testing.saveData;

public class CustomizationFragment extends Fragment{

    private FragmentCustomizationBinding binding;
    ImageView enemy;
    ImageView enemy2;
    ImageView currentEnemy;
    Button enemy1Button;
    Button enemy2Button;
    EditText nameField;
    int currentCustomization = 0;

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


        com.example.testing.ui.customizationTab.CustomizationViewModel CustomizationViewModel =
                new ViewModelProvider(this).get(com.example.testing.ui.customizationTab.CustomizationViewModel.class);

        binding = FragmentCustomizationBinding.inflate(inflater, container, false);

        //return binding.getRoot();
        return CustomizationFragment;

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        view.findViewById(R.id.black_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.BLACK;
                changeColor(color);
            }

        });
        view.findViewById(R.id.purple_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.MAGENTA;
                changeColor(color);
            }

        });
        view.findViewById(R.id.yellow_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.YELLOW;
                changeColor(color);
            }

        });
        view.findViewById(R.id.green_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.GREEN;
                changeColor(color);
            }

        });
        view.findViewById(R.id.enemy1Button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                enemy1Button.setBackgroundColor(Color.LTGRAY);
                enemy2Button.setBackgroundColor(Color.TRANSPARENT);
                currentEnemy = enemy;
            }
        });
        view.findViewById(R.id.enemy2Button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                enemy2Button.setBackgroundColor(Color.LTGRAY);
                enemy1Button.setBackgroundColor(Color.TRANSPARENT);
                currentEnemy = enemy2;
            }
        });
        view.findViewById(R.id.blue_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.BLUE;
                changeColor(color);
            }

        });
        view.findViewById(R.id.red_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.RED;
                changeColor(color);
            }

        });
        view.findViewById(R.id.submit_Button).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                saveData saveData = new saveData();
                String virusName = nameField.getText().toString();
                Log.v("Virus Name", virusName);
                saveData.setVirusNamePart(virusName, currentCustomization);
                currentCustomization++;
                NavHostFragment.findNavController(CustomizationFragment.this).navigate(R.id.action_navigation_notifications_to_navigation_customizationcheck);

            }
        });
    }
    private void changeColor(int color) {
        currentEnemy.setColorFilter(color);

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}