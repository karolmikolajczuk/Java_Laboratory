package com.karolmikolajczuk;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pet extends Animal {
    public Pet() {
        super();
    }

    public Pet(String name, SPECIES species, File picture) {
        super(name, species, picture);
    }

    public Pet(String name, SPECIES species, boolean isAlive, File picture) {
        super(name, species, isAlive, picture);
    }

    /**
     * Procedural method for going on a walk with animal.
     * @param distance how long the walk was.
     */
    public void walk(Double distance) {
        while (distance > 0) {
            System.out.println("Distance to make: " + distance);
            --distance;

            this.weight = this.weight.subtract(new BigDecimal(1));
            this.weight = this.weight.setScale(2, RoundingMode.HALF_UP);

            //if (this.isHungry()) while(this.isHungry()) this.feed();
            if (!this.currentState()) return;
        }
        System.out.println("Weight is losing, now: " + this.weight);
    }

}
