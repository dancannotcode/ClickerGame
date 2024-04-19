package com.example.testing;

public class virusModel {
    String virusColor;
    String virusType;
    String virusName;
    int image;

    public virusModel(String virusColor, String virusType, String virusName, int image) {
        this.virusColor = virusColor;
        this.virusType = virusType;
        this.virusName = virusName;
        this.image = image;
    }

    public String getVirusColor() {
        return virusColor;
    }

    public String getVirusType() {
        return virusType;
    }

    public String getVirusName() {
        return virusName;
    }

    public int getImage(){
        return image;
    }

}
