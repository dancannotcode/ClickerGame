package com.example.testing.ui.home;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * A Fragment representing the home screen of the application.
 * This fragment is responsible for managing interaction with enemies on the screen,
 * playing sounds, and handling game progression based on user interaction.
 */
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ImageView imageView;
    private ImageView[] enemies = new ImageView[5];

    private boolean isImageVisible = true;
    MediaPlayer mediaPlayer = new MediaPlayer();

    private int currentProgress = 0;
    private ProgressBar progressBar;
    private saveData saveData;

    TextView showLevelTextView;

    /**
     * Inflates the home fragment view, initializes components, and sets up click listeners.
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return the root View of the inflated layout, to be attached to the fragment's UI.
     */
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
        saveData = new saveData();
        fetchAndUpdateLevelCount();
        currentProgress = saveData.getCurrentProgress();

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

    private void fetchAndUpdateLevelCount() {
        // Fetch levelCount from saveData
        AtomicInteger levelCount = saveData.getLevelCount();
        // Update UI with fetched levelCount
        showLevelTextView.setText(String.valueOf(levelCount));
    }
    /**
     * Randomly moves an ImageView to simulate enemy movement.
     * @param imageView The ImageView to move.
     */
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
    /**
     * Manages game progression based on user interactions.
     * @param v The view that was clicked.
     */
    private void clickProgression(View v) {
        String userId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        //create

        assert userEmail != null;
        FirebaseFirestore.getInstance().collection(userEmail).document(userId).get()
                .addOnSuccessListener(documentSnapshot -> {
                    AtomicInteger clicksMade = saveData.getClickNum();
                    if (documentSnapshot.exists() && documentSnapshot.contains("Clicks_Made")) {
                        // If document exists retrieve clicks made
                        clicksMade.set(documentSnapshot.getLong("Clicks_Made").intValue());
                    } else {
                        // If the field doesn't exist or document doesn't exist, set clicksMade to 0
                        clicksMade.set(0);
                    }
                    //increase clicks made
                    clicksMade.incrementAndGet();

                    saveData.setClickNum(clicksMade);
                    //stores the click made
                    FirebaseFirestore.getInstance().collection(userEmail).document(userId)
                            .set(new HashMap<String, Object>() {{
                                put("Clicks_Made", clicksMade.intValue());
                            }})
                            .addOnSuccessListener(aVoid -> {
                                // Successfully updated Clicks_Made in Firestore
                            })
                            .addOnFailureListener(e -> {
                                // Handle failure
                            });
                })
                .addOnFailureListener(e -> {
                    // Handle failure
                });
        // Get the value of the text view
        String countString = showLevelTextView.getText().toString();
        Integer count = Integer.parseInt(countString);

        // Display the new value in the text view.
        progressBar = binding.getRoot().findViewById(R.id.progress_Horizontal);


        AtomicInteger levelCount;
        levelCount = saveData.getLevelCount();
        int level = levelCount.get() * 100;

        // Reset progress bar to show leveling up
        if(currentProgress >= level)
        {
            currentProgress = 0;
            // Convert value to a number and increment it
            int currLevelCount = levelCount.incrementAndGet();
            levelCount.set(currLevelCount);
        }

        Random r = new Random();
        int randExp = r.nextInt(15) + 1;
        currentProgress = currentProgress + randExp;
        if (progressBar != null) {
            progressBar.setProgress(currentProgress);
            progressBar.setMax(level);
        }

        saveData.setLevelCount(levelCount);
        showLevelTextView.setText(String.valueOf(levelCount.get()));

        FirebaseFirestore.getInstance().collection(userEmail).document(userId).get()
                .addOnSuccessListener(documentSnapshot -> {
                    AtomicInteger finalLevelCount = levelCount;
                    Log.v("level: ", String.valueOf(finalLevelCount));
                    if (documentSnapshot.exists() && documentSnapshot.contains("LevelCount")) { // Change to "LevelCount"
                        // If document exists and contains "LevelCount", retrieve it
                        finalLevelCount.set((int) (long) documentSnapshot.getLong("LevelCount"));
                        saveData.setLevelCount(levelCount);
                    }
                })
                .addOnFailureListener(e -> {
                    // Handle failure
                    Log.e("FirestoreUpdate", "Failed to update LevelCount: " + e.getMessage());

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
    public void onPause() {
        saveDataToFirestore();
        super.onPause();
    }
    @Override
    public void onStop() {
        saveDataToFirestore();
        super.onStop();
    }

    /**
     * Cleans up resources when the View is about to be destroyed.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        saveDataToFirestore();
        binding = null;
    }

    private void saveDataToFirestore() {
        // Add the code to save data to Firestore here
        String userId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        // Update Firestore with the latest data
        FirebaseFirestore.getInstance().collection(userEmail).document(userId)

                .update("LevelCount", saveData.getLevelCount().get()) // Save the levelCount value
                .addOnSuccessListener(aVoid -> {
                    // Successfully updated levelCount in Firestore
                })
                .addOnFailureListener(e -> {
                    // Handle failure
                    Log.e("FirestoreUpdate", "Failed to update LevelCount: " + e.getMessage());
                });
    }
}