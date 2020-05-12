package com.karolmikolajczuk;

import java.io.File;

public class FarmAnimal extends Animal implements Edible {
    public FarmAnimal() {
        super();
    }

    public FarmAnimal(String name, SPECIES species, File picture) {
        super(name, species, picture);
    }

    public FarmAnimal(String name, SPECIES species, boolean isAlive, File picture) {
        super(name, species, isAlive, picture);
    }

    @Override
    public void beEaten() {
        super.isAlive = false;
        super.weight = null;
    }
}
