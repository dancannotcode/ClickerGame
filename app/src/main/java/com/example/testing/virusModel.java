package com.example.testing;

/**
 * The {@code virusModel} class represents a data model for a virus in the application.
 * It encapsulates details about the virus such as its color, type, name, and associated image resource.
 */
public class virusModel {
    private String virusColor; // Color of the virus
    private String virusType;  // Type of the virus
    private String virusName;  // Name of the virus
    private int image;         // Drawable resource ID for the image of the virus

    /**
     * Constructs a new {@code virusModel} with specified attributes for a virus.
     *
     * @param virusColor the color of the virus
     * @param virusType the type of the virus
     * @param virusName the name of the virus
     * @param image the drawable resource ID for the image of the virus
     */
    public virusModel(String virusColor, String virusType, String virusName, int image) {
        this.virusColor = virusColor;
        this.virusType = virusType;
        this.virusName = virusName;
        this.image = image;
    }

    /**
     * Returns the color of the virus.
     *
     * @return the color of the virus
     */
    public String getVirusColor() {
        return virusColor;
    }

    /**
     * Returns the type of the virus.
     *
     * @return the type of the virus
     */
    public String getVirusType() {
        return virusType;
    }

    /**
     * Returns the name of the virus.
     *
     * @return the name of the virus
     */
    public String getVirusName() {
        return virusName;
    }

    /**
     * Returns the image resource ID for the virus.
     *
     * @return the drawable resource ID for the image
     */
    public int getImage() {
        return image;
    }

}
