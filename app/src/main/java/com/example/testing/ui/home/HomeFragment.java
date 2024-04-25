package com.example.testing.ui.home;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.R;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.testing.databinding.FragmentHomeBinding;
import com.example.testing.saveData;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ImageView imageView;
    private ImageView[] enemies = new ImageView[5];

    private boolean isImageVisible = true;
    MediaPlayer mediaPlayer = new MediaPlayer();

    private int currentProgress = 0;
    private ProgressBar progressBar;

    private int levelCount = 0;
    TextView showLevelTextView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View fragmentHomeLayout = binding.getRoot();
        //displays the images
        enemies[0] = fragmentHomeLayout.findViewById(R.id.imageView);
        enemies[1] = fragmentHomeLayout.findViewById(R.id.imageView2);
        enemies[2] = fragmentHomeLayout.findViewById(R.id.imageView3);
        enemies[3] = fragmentHomeLayout.findViewById(R.id.imageView4);
        enemies[4] = fragmentHomeLayout.findViewById(R.id.imageView5);
        showLevelTextView = fragmentHomeLayout.findViewById(R.id.text_level);
        saveData saveData = new saveData();
        currentProgress = saveData.getCurrentProgress();
        levelCount = saveData.getLevelCount();

        // Get the value of the text view and set level from save.
        String countString = showLevelTextView.getText().toString();
        Integer count = Integer.parseInt(countString);
        count = count + levelCount;
        showLevelTextView.setText(count.toString());

        // Set OnClickListener to move the ImageView to a different spot when clicked
            // Set OnClickListener to move the ImageView to a different spot when clicked
        for (int i = 0; i < enemies.length; i++) {
                final int enemyIndex = i;
                enemies[enemyIndex].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.gameclick);
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.reset();
                                mp.release();
                                mp = null;
                            }
                        });
                        mediaPlayer.start();
                        moveImage(enemies[enemyIndex]); // moves the enemy widget
                        clickProgression(v);
                    }
                });
            }
            return binding.getRoot();

        }


    private void moveImage(ImageView imageView) {
        if (isImageVisible) {
            // If image is visible, change its position

            // Use Random number generator to move enemy widget to a random
            // location

            int max = 200;
            int min = -200;

            Random random1 = new java.util.Random();
            Integer randomNumber1 = 0;
            randomNumber1 = random1.nextInt((max - min) + 1) + min;

            Random random2 = new java.util.Random();
            Integer randomNumber2 = 0;
            randomNumber2 = random2.nextInt((max - min) + 1) + min;

            imageView.animate()
                    .translationXBy(randomNumber1)  // Move it a random amount of pixels to the right or left
                    .translationYBy(randomNumber2)  // Move it a random amount of pixels upward or downward
                    .setDuration(500)     // Animation duration
                    .start();
        } else {
            // If image is not visible, reset its position
            imageView.animate()
                    .translationX(0)  // Move it back to its original X position
                    .translationY(0)  // Move it back to its original Y position
                    .setDuration(500) // Animation duration
                    .start();
        }

        // Toggle the visibility state
        isImageVisible = !isImageVisible;
    }

    private void clickProgression(View v) {
        //get user ID to track score/click count
        String userId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        int score = 0;

        assert userEmail != null;
        FirebaseFirestore.getInstance().collection(userEmail).document(userId).get()
                .addOnSuccessListener(documentSnapshot -> {
                            AtomicInteger clicksMade = new AtomicInteger();
                            if (documentSnapshot.exists()) {
                                // If document exists, retrieve clicks made
                                clicksMade.set(documentSnapshot.getLong("Clicks_Made").intValue());
                            }
        //increase clicks made
        clicksMade.incrementAndGet();
        //stores the click made
                    FirebaseFirestore.getInstance().collection(userEmail).document(userId)
                            .set(new HashMap<String, Object>() {{
                                put("Clicks_Made", clicksMade.intValue());
                            }});
        // Get the value of the text view
        String countString = showLevelTextView.getText().toString();
        Integer count = Integer.parseInt(countString);

        // Display the new value in the text view.
        progressBar = binding.getRoot().findViewById(R.id.progress_Horizontal);

        int level = levelCount * 100;

        // Reset progress bar to show leveling up
        if(currentProgress >= level)
        {
            currentProgress = 0;
            // Convert value to a number and increment it
            count++;
            levelCount = count;
        }

        Random r = new Random();
        int randExp = r.nextInt(15) + 1;
        currentProgress = currentProgress + randExp;
        progressBar.setProgress(currentProgress);
        progressBar.setMax(level);
        showLevelTextView.setText(count.toString());
                });
    }
// ***************************************************************************************/
// *    Title: MediaPlayer sound source code
// *    Author: global_warming
// *    Date: 2018
// *    Code version: 1.0
// *    Availability: https://stackoverflow.com/questions/48534509/my-android-app-stop-playing-sound-on-button-tap-after-some-time
// *
// ***************************************************************************************/



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}