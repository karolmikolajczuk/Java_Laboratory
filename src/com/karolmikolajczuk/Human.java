package com.karolmikolajczuk;

public class Human {
    private String name;
    private String surname;
    private Double age;
    private Phone number;

    public Human() {

    }

    public Human(String name, String surname, Double age, Phone number) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Phone getNumber() {
        return number;
    }

    public void setNumber(Phone number) {
        this.number = number;
    }
}
