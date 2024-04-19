package com.example.testing;


public class saveData {
    String[] virusName = {"Name: A","Name: B","Name: C","Name: D","Name: E","Name: F","Name: G"};
    int[] virusPicture = {R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark};
    int currentCustomization = 0;

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
