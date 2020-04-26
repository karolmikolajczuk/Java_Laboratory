package com.karolmikolajczuk;

public class Human {
    private String name;
    private String surname;
    private Double age;
    private Phone number;
    private Animal pet;
    private Car car;
    private Double salary;
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
     * Constructor of Human with all parameters
     * @param name name of human
     * @param surname last name of human
     * @param age current age of human
     * @param number phone number of human
     * @param pet animal object that represents pet
     * @param car car object that represents car
     */
    public Human(String name, String surname, Double age, Phone number, Animal pet, Car car) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.car = car;
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

    /**
     * Getting current car that human has.
     * @return human's car object.
     */
    public Car getCar() {
        return car;
    }

    /**
     * Setting new car for human.
     * @param car new car.
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Current human's salary
     * @return present salary
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * Setting new salary - hopefully always increasingly.
     * @param salary new salary for human.
     */
    public void setSalary(Double salary) throws IllegalArgumentException {
        if (salary < 0)
            throw new IllegalArgumentException("Salary can't be smaller than 0");

        // set new salary first, cause we can't send this data everywhere and
        // don't change it.
        // imagine the situation when you send this everywhere and system shutdown's
        // accidentally and you don't have changed salary yet but everyone thinks it happened.
        this.salary = salary;
        System.out.println("New salary was send to accountant system.");
        System.out.println("You need to go to HR department to get an annex to the contract.");
        System.out.println("Basically, government knows what's your new salary, so you don't have to hide it.");
    }

    /**
     * Giving a raise to the human, no new salary,
     * but the extension to the current salary.
     * @param raise the raise
     */
    public void raiseSalary(Double raise) throws IllegalArgumentException {
        if (raise < 0)
            throw new IllegalArgumentException("Raise can't be smaller than 0");

        this.salary = this.salary + raise;
    }
}
