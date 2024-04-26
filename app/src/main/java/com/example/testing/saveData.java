package com.example.testing;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The {@code saveData} class manages the game data such as progress, customization, and levels.
 * It uses Firebase Firestore to store and retrieve user-specific data, maintaining synchronization
 * with Firebase Authentication to handle user identification.
 */
public class saveData {
    // Arrays holding names and pictures for virus customizations
    String[] virusName = {"Name: A","Name: B","Name: C","Name: D","Name: E","Name: F","Name: G"};
    int[] virusPicture = {R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark};

    int currentCustomizations = 0;
    private AtomicInteger levelCount = new AtomicInteger(1);

    int currentProgress = 0;
    AtomicInteger clickNum = new AtomicInteger(0);

    /**
     * Returns the current number of clicks as an AtomicInteger.
     *
     * @return the number of clicks
     */
    public AtomicInteger getClickNum() {
        return clickNum;
    }

    /**
     * Sets the number of clicks to a new AtomicInteger value.
     *
     * @param clickNum the new value for the click number
     */
    public void setClickNum(AtomicInteger clickNum) {
        this.clickNum = clickNum;
    }

    /**
     * Returns the current number of customizations made by the user.
     *
     * @return the number of customizations
     */
    public int getCurrentCustomizations() {
        return currentCustomizations;
    }

    /**
     * Sets the current number of customizations.
     *
     * @param currentCustomizations the new customization count
     */
    public void setCurrentCustomizations(int currentCustomizations) {
        this.currentCustomizations = currentCustomizations;
    }
    public AtomicInteger getLevelCount() {
        return levelCount;
    }

    public void setLevelCount(AtomicInteger levelCount) {
       this.levelCount = levelCount;
    }

    /**
     * Returns the current progress in the game.
     *
     * @return the current progress
     */
    public int getCurrentProgress() {
        return currentProgress;
    }

    /**
     * Sets the current progress in the game.
     *
     * @param currentProgress the new progress value
     */
    public void setCurrentProgress(int currentProgress) {
        this.currentProgress = currentProgress;
    }

    /**
     * Returns an array of resource IDs for the virus pictures.
     *
     * @return an array of drawable resource IDs
     */
    public int[] getVirusPicture() {
        return virusPicture;
    }

    /**
     * Returns an array of names for the viruses.
     *
     * @return an array of virus names
     */
    public String[] getVirusName() {
        return virusName;
    }

    /**
     * Updates a part of the virus name array at a specific index.
     *
     * @param virusNameCurrent the new virus name to set
     * @param part the index at which to set the new name
     */
    public void setVirusNamePart(String virusNameCurrent, int part) {
        this.virusName[part] = virusNameCurrent;
    }
}
