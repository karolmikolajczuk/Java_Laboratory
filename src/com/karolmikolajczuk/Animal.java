package com.karolmikolajczuk;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Animal class, that represents an animal.
 */
public class Animal {

    private String name;
    private boolean isAlive;
    private File picture;

    /**
     * Constructor for an Animal class.
     * @param name current name of an animal
     * @param picture picture file of an animal
     */
    public Animal(String name, File picture) {
        this.name = name;
        this.picture = picture;
    }

    /**
     * Method returns the current name of an animal
     * @return the current name of an animal
     */
    public String getName() {
        return name;
    }

    /**
     * Method sets a new name for an animal.
     * @param name new name of animal
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Methods returns a file with picture of an animal.
     * @return file with picture
     */
    public File getPicture() {
        return picture;
    }

    /**
     * Method sets in private variable a file to a picture of an animal.
     * @param picture file with picture
     */
    public void setPicture(File picture) {
        this.picture = picture;
    }

}
