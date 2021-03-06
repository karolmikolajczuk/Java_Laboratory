package com.karolmikolajczuk;

import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Animal class, that represents an animal.
 */
public abstract class Animal implements Sellable, Feedable {

    protected SPECIES species;
    protected String name;
    protected boolean isAlive;
    protected BigDecimal weight;
    protected File picture;

    public Animal() {
        this.species = SPECIES.NONE;
        this.name = "";
        this.isAlive = false;
        this.weight = new BigDecimal("0.0");
        this.picture = null;
    }

    /**
     * Constructor for an Animal class.
     * @param name current name of an animal
     * @param picture picture file of an animal
     * weight weight of an animal is set basing
     *                on specie.
     * @param species species.
     */
    public Animal(String name, SPECIES species, File picture) {
        this.name = name;
        this.species = species;
        try {
            this.weight = this.weightOfSpecies(species);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.weight = new BigDecimal(1); // default
        }
        this.picture = picture;
        this.isAlive = true;
    }

    /**
     * Constructor for an Animal class.
     * @param name current name of an animal
     * @param picture picture file of an animal
     * weight weight of an animal is set basing
     *                on specie.
     * @param isAlive current state of an animal's existence.
     */
    public Animal(String name, SPECIES species, boolean isAlive, File picture) {
        this.name = name;
        this.species = species;
        this.isAlive = isAlive;
        try {
            this.weight = this.weightOfSpecies(species);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.weight = new BigDecimal(1); // default
        }
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
     * Method return a specie.
     * @return the specie of an animal
     */
    public SPECIES getSpecies() {
        return species;
    }

    /**
     * Method changes current specie.
     * @param species actual specie of an animal.
     */
    public void setSpecies(SPECIES species) {
        this.species = species;
    }

    /**
     * Is the animal alive?
     * @return current state of an animal.
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Change the current state of an animal.
     * @param alive present state.
     */
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Get current weight of an animal.
     * @return present weight.
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * Set new weight of an animal.
     * @param weight new weight.
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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

    /**
     * Procedural method for feeding an animal.
     */
    @Override
    public void feed() throws IllegalStateException {
        if (!this.isAlive())
            throw new IllegalStateException("Animal is already dead, buy a new one.");

        this.weight = this.weight.add(new BigDecimal(1));
        System.out.println("Weight is gaining, now: " + this.weight);
    }

    /**
     * Procedural method for feeding an animal.
     * @param food_weight the weight of food animal will eat
     */
    @Override
    public void feed(Double food_weight) throws IllegalStateException {
        if (!this.isAlive())
            throw new IllegalStateException("Animal is already dead, buy a new one.");

        this.weight = this.weight.add(new BigDecimal(food_weight));
        System.out.println("Weight is gaining, now: " + this.weight);
    }

    /**
     * Checking if the animal is hungry.
     * @return true if hungry, false if not.
     */
    public boolean isHungry() {
        if (this.weight.doubleValue() <= 5.0 && this.currentState()) {
            System.out.println("[" + this.name + "]: I'm starving..");
            return true;
        }
        System.out.println("[" + this.name + "]: I'm not hungry..");
        return false;
    }

    /**
     * Check if the animal is dead or not (bases on animals's weight).
     * @return true if alive, false if dead.
     */
    public boolean currentState() {
        if (this.weight.doubleValue() <= 0) {
            System.out.println(this.name + " is dead.");
            this.isAlive = false;
            return false;
        }

        System.out.println(this.name + " lives.");
        return true;
    }

    /**
     * Method that is used in constructor for setting a weight of an animal.
     * @param specie specie of an animal
     * @return value of default weight of an animal, basing on specie.
     */
    private BigDecimal weightOfSpecies(SPECIES specie) throws IllegalArgumentException {
        switch (specie) {
            case CAT:
                return new BigDecimal(4);
            case DOG:
                return new BigDecimal(10);
            case RAT:
            case HAMSTER:
                return new BigDecimal(1);
            case FISH:
                return BigDecimal.valueOf(0.3);
            case MOUSE:
                return BigDecimal.valueOf(0.7);
            case PARROT:
                return new BigDecimal(2);
            case COW:
                return new BigDecimal(100);
            case SHEEP:
                return new BigDecimal(20);
        }

        throw new IllegalArgumentException("Wrong argument, somehow..");
    }

    @Override
    public boolean equals(Object obj) {
        Animal animal = (Animal) obj;

        return this.isAlive == animal.isAlive &&
                this.weight.equals(animal.weight) &&
                this.species == animal.species &&
                this.name.equals(animal.name) &&
                this.picture == animal.picture;
    }

    @Override
    public String toString() {
        return this.name + " weighs: " + this.weight + " and is " + this.species;
    }

    @Override
    public boolean sell(Human seller, Human buyer, BigDecimal price) {
        if (seller.getPet() == null)  {
            System.out.println("He doesn't have a pet. It's scam.");
            return false;
        }
        if (buyer.getMoney() < price.doubleValue()) {
            System.out.println("He doesn't have money. It's a cheater.");
            return false;
        }

        buyer.addMoney(price.doubleValue() * -1);
        seller.addMoney(price.doubleValue());

        buyer.setPet(seller.getPet());
        seller.setPet(null);
        System.out.println("Transaction between " + seller + " and " + buyer + " is done successfully.");

        return true;
    }

    @Override
    public boolean sell(Human seller, int index, Human buyer, BigDecimal price) {
        return false;
    }
}
