package com.karolmikolajczuk;

import devices.Car;
import devices.ORDER;
import devices.Phone;
import org.w3c.dom.ranges.RangeException;

import java.util.Arrays;
import java.util.Collections;

public class Human {
    private int GARAGE_SIZE;
    private String name;
    private String surname;
    private Double age;
    private Phone number;
    private Animal pet;
    private Car[] garage;
    private Double salary;
    private Double cash;

    /**
     * Default constructor.
     */
    public Human() {
        this.name = "";
        this.surname = "";
        this.age = 0.0;
        this.number = new Phone();
        this.pet = new Pet();
        this.salary = 0.0;
        this.cash = 0.0;
        this.GARAGE_SIZE = 5;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
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
        this.pet = new Pet();
        this.salary = 0.0;
        this.cash = 0.0;
        this.GARAGE_SIZE = 5;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
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
        this.salary = 0.0;
        this.cash = 0.0;
        this.GARAGE_SIZE = 5;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
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
        this.salary = 0.0;
        this.cash = 0.0;
        this.GARAGE_SIZE = 5;

        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
        this.garage[0] = car;
    }

    /**
     * Constructor that contains another important parameter, the size of a garage.
     * @param name  the name of a human
     * @param surname   the surname of a human
     * @param age   the age of a human
     * @param number    the phone number of a human
     * @param pet   the pet of a human (if exists) can be set as null tbh
     * @param GARAGE_SIZE   the size of a garage of human
     */
    public Human(String name, String surname, Double age, Phone number, Animal pet, int GARAGE_SIZE) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.cash = 0.0;

        this.GARAGE_SIZE = GARAGE_SIZE;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
    }

    /**
     * Constructor that contains another important parameter, the size of a garage.
     * @param name  the name of a human
     * @param surname   the surname of a human
     * @param age   the age of a human
     * @param number    the phone number of a human
     * @param pet   the pet of a human (if exists) can be set as null tbh
     * @param GARAGE_SIZE   the size of a garage of human
     * @param car   the car of a human that has to be set in garage
     */
    public Human(String name, String surname, Double age, Phone number, Animal pet, int GARAGE_SIZE, Car car) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.cash = 0.0;

        this.GARAGE_SIZE = GARAGE_SIZE;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
        this.garage[0] = car;
    }

    /**
     * Constructor that contains another important parameter, the size of a garage.
     * @param name  the name of a human
     * @param surname   the surname of a human
     * @param age   the age of a human
     * @param number    the phone number of a human
     * @param pet   the pet of a human (if exists) can be set as null tbh
     * @param GARAGE_SIZE   the size of a garage of human
     * @param car   the array of cars of a human that have to be set in garage
     */
    public Human(String name, String surname, Double age, Phone number, Animal pet, int GARAGE_SIZE, Car[] car) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.cash = 0.0;

        this.GARAGE_SIZE = GARAGE_SIZE;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }

        for (int index = 0; index < car.length; ++index) {
            this.garage[index] = car[index];
        }
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
     * Getting current state o garage that human owns.
     * @return human's cars objects.
     */
    public Car[] getCarsFromGarage() {
        return this.garage;
    }

    /**
     * Method that returns car if exist at specific garage's position
     * @param garage_position position of garage that (probably) has a car in it
     * @return car from specific garage's position
     */
    public Car getCar(int garage_position) {
        return this.garage[garage_position];
    }

    /**
     * Setting new car for human.
     * @param car new car.
     */
    public void setCar(Car car) {
        if (this.salary.isNaN())
            throw new IllegalStateException("Dude, you have no job.");

        if (this.salary < (car.getValue().doubleValue()/12))
            throw new IllegalStateException("Go study, get new job(better payment) or go for a raise(big raise).");

        // if garage is not empty (no place for car then say it)
        if (this.garage[GARAGE_SIZE-1] != null)
            throw new IllegalStateException("No place in garage.");

        //
        if (this.salary > (car.getValue().doubleValue()/12))
            System.out.println("Woah, big fella. You got " + car.getModel() + ", but you have bought it on credit.");
        else
            System.out.println("Congratulations, you bought " + car.getModel());


        // check which place in garage is empty, cause we don't want to
        // overwrite a car in garage, and if empty place then set car
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            if (this.garage[index] == null) {
                this.garage[index] = car;
                break;
            }
        }
    }

    public void setCar(Car car, int index) {
        if (this.salary.isNaN())
            throw new IllegalStateException("Dude, you have no job.");

        if (this.salary < (car.getValue().doubleValue()/12)) {
            System.out.println("Go study, get new job(better payment) or go for a raise(big raise).");
            return;
        }

        // if garage is not empty (no place for car then say it)
        if (this.garage[index] != null) {
            System.out.println("Currently in this place You have a car.");
            return;
        }

        if (this.salary > car.getValue().doubleValue()) {
            System.out.println("Congratulations, you bought " + car.getModel());
        } else if (this.salary > (car.getValue().doubleValue()/12)) {
            System.out.println("Woah, big fella. You got " + car.getModel() + ", but you have bought it on credit.");
        }

        this.garage[index] = car;
    }

    /**
     * This method delete's car from specific index given as parameter
     * @param index index of car in garage
     */
    public void deleteCar(int index) {
        this.garage[index] = null;
    }

    /**
     * Methods returns the size of a garage
     * @return size of garage
     */
    public int getGarageSize() {
        return this.GARAGE_SIZE;
    }

    /**
     * Method checks current state of garage and returns the number of cars in it.
     * @return numbers of cars in garage
     * @throws IllegalArgumentException
     */
    public int howManyCarsInGarage() throws IllegalArgumentException {
        int count_cars = 0;
        for (int index = 0; index < this.GARAGE_SIZE; ++index) {
            if (this.garage[index] != null) ++count_cars;
        }

        // basically it is not possible, but let's make sure everything will be ok when returning
        if (count_cars > this.GARAGE_SIZE)
            throw new IllegalArgumentException("You cant have more cars than places in garage");

        return count_cars;
    }

    /**
     * Current human's salary
     * @return present salary
     */
    public Double getSalary() {
        if (!this.salary.isNaN()) return salary;

        return 0.0;
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
    public void raiseSalary(Double raise) throws IllegalArgumentException, IllegalAccessException {
        if (raise < 0)
            throw new IllegalArgumentException("Raise can't be smaller than 0");
        if (!(this.salary > 0))
            throw new IllegalAccessException("You can't get raise if you have no job..");

        this.salary = this.salary + raise;
    }

    @Override
    public boolean equals(Object obj) {
        Human human = (Human) obj;
        return this.name.equals(human.name) &&
                this.surname.equals(human.surname) &&
                this.age.doubleValue() == human.age.doubleValue() &&
                this.salary.doubleValue() == human.salary.doubleValue() &&
                this.number.equals(human.number) &&
                this.pet.equals(human.pet) &&
                this.garage.equals(human.garage);
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " is " +
                this.age + " old and has a pet: " + this.pet +
                " and his phone number is: " + this.number;
    }

    /**
     * Setter for money, but we are increasing current state.
     * @param money the amount of money which we are increasing by
     */
    public void addMoney(Double money) {
        this.cash += money;
    }

    /**
     * Getter of money
     * @return current state of money of human
     */
    public Double getMoney() {
        return this.cash;
    }

    /**
     * This methods sort cars in Garage
     * @param order The order this function will sort car's
     */
    public void sortCarsInGarage(ORDER order) {
        // check if there is anything to sort
        if (this.howManyCarsInGarage() < 2) return;

        // rule #1 there is no way car's are set like this:
        // xVxxxVx
        // car's are always set like this:
        // VVxxxx
        if (ORDER.ASCENDING == order) {
            for (int index = 0; index < this.howManyCarsInGarage(); ++index) {
                for (int jndex = index + 1; jndex < this.howManyCarsInGarage(); ++jndex) {
                    if (this.garage[index].getYear() > this.garage[jndex].getYear()) {
                        Car temp = this.garage[jndex];
                        this.garage[jndex] = this.garage[index];
                        this.garage[index] = temp;
                    }
                }
            }
        } else {
            for (int index = 0; index < this.howManyCarsInGarage(); ++index) {
                for (int jndex = index + 1; jndex < this.howManyCarsInGarage(); ++jndex) {
                    if (this.garage[index].getYear() < this.garage[jndex].getYear()) {
                        Car temp = this.garage[jndex];
                        this.garage[jndex] = this.garage[index];
                        this.garage[index] = temp;
                    }
                }
            }
        }

    }

}
