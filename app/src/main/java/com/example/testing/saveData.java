package com.example.testing;

public class saveData {
    String[] virusName = {"Name: A","Name: B","Name: C","Name: D","Name: E","Name: F","Name: G"};
    int[] virusPicture = {R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark};
    int currentCustomizations = 0;
    int levelCount = 1;
    int currentProgress = 0;
    int clickNum = 0;

    public int getClickNum() {
        return clickNum;
    }

    public void setClickNum(int clickNum) {
        this.clickNum = clickNum;
    }

    public int getCurrentCustomizations() {
        return currentCustomizations;
    }

    public void setCurrentCustomizations(int currentCustomizations) {
        this.currentCustomizations = currentCustomizations;
    }

    public int getLevelCount() {
        return levelCount;
    }

    public void setLevelCount(int levelCount) {
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
