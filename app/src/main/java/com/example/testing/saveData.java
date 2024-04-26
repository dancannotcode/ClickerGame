package com.example.testing;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


public class saveData {
    String[] virusName = {"Name: A","Name: B","Name: C","Name: D","Name: E","Name: F","Name: G"};
    int[] virusPicture = {R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark};
    int currentCustomizations = 0;
    private AtomicInteger levelCount = new AtomicInteger(1);

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

    public AtomicInteger getLevelCount() {
        return levelCount;
    }

    public void setLevelCount(AtomicInteger levelCount) {
       this.levelCount = levelCount;
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
