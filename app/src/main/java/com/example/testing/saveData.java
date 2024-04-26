package com.example.testing;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


public class saveData {
    String[] virusName = {"Name: A","Name: B","Name: C","Name: D","Name: E","Name: F","Name: G"};
    int[] virusPicture = {R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark};
    int currentCustomizations = 0;
    private int levelCount = 1;

    int currentProgress = 0;
    AtomicInteger clickNum = new AtomicInteger();


    public AtomicInteger getClickNum() {
        return clickNum;
    }

    public void setClickNum(AtomicInteger clickNum) {
        this.clickNum = clickNum;
    }

    public int getCurrentCustomizations() {
        return currentCustomizations;
    }

    public void setCurrentCustomizations(int currentCustomizations) {
        this.currentCustomizations = currentCustomizations;
    }

    public int getLevelCount() {
        String userId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        // Retrieve levelCount from Firestore document
        FirebaseFirestore.getInstance().collection(userEmail).document(userId).get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists() && documentSnapshot.contains("levelCount")) {
                        // If document exists and contains "levelCount", retrieve it
                        levelCount = documentSnapshot.getLong("levelCount").intValue();
                    } else {
                        // If the field doesn't exist or document doesn't exist, set levelCount to default
                        levelCount = 1; // Set to default value if not found
                    }
                })
                .addOnFailureListener(e -> {
                    // Handle failure
                });
        return levelCount;
    }

    public void setLevelCount(int levelCount) {

        String userId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        // Set the levelCount field in Firestore document
        FirebaseFirestore.getInstance().collection(userEmail).document(userId)
                .update("levelCount", levelCount)
                .addOnSuccessListener(aVoid -> {
                    // Successfully updated levelCount in Firebase
                })
                .addOnFailureListener(e -> {
                    // Handle failure
                });
    }

    public int getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(int currentProgress) {
        this.currentProgress = currentProgress;
    }

    public int[] getVirusPicture() {
        return virusPicture;
    }

    public String[] getVirusName() {
        return virusName;
    }

    public void setVirusNamePart(String virusNameCurrent, int part) {
        this.virusName[part] = virusNameCurrent;
    }
}
