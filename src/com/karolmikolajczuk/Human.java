package com.karolmikolajczuk;

public class Human {
    private String name;
    private String surname;
    private Double age;
    private Phone number;
    private Animal pet;

    /**
     * Default constructor.
     */
    public Human() {

    }

    /**
     * Constructor of Human with basic parameters
     * @param name name of human
     * @param surname last name of human
     * @param age current age of human
     * @param number phone number of human
     */
    public Human(String name, String surname, Double age, Phone number) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
    }

    /**
     * Constructor of Human with all parameters
     * @param name name of human
     * @param surname last name of human
     * @param age current age of human
     * @param number phone number of human
     * @param pet animal object that represents pet
     */
    public Human(String name, String surname, Double age, Phone number, Animal pet) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
    }

    /**
     * Get current name of human
     * @return current name
     */
    public String getName() {
        return name;
    }

    /**
     * Set new name for human
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get current last name
     * @return current last name
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set new last name for human
     * @param surname new last name
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Method return current age
     * @return current age of human
     */
    public Double getAge() {
        return age;
    }

    /**
     * Setting new age for human
     * @param age new age
     */
    public void setAge(Double age) {
        this.age = age;
    }

    /**
     * Getting current number of human
     * @return current number
     */
    public Phone getNumber() {
        return number;
    }

    /**
     * Setting new number of phone
     * @param number new phone number
     */
    public void setNumber(Phone number) {
        this.number = number;
    }

    /**
     * Getting current animal (object)
     * @return (object) of an animal
     */
    public Animal getPet() {
        return pet;
    }

    /**
     * Setting new animal
     * @param pet new animal
     */
    public void setPet(Animal pet) {
        this.pet = pet;
    }
}
