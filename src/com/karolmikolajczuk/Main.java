package com.karolmikolajczuk;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Human John = new Human("John", "Doe", 20.0,
                new Phone(123456789, "PLAY"),
                new Animal("Fifi", SPECIES.DOG, new File("")));

        System.out.println(John.getName());
        System.out.println(John.getSurname());
        System.out.println(John.getAge());
        System.out.println(John.getNumber().getNumber());

        System.out.println();
        System.out.println(John.getPet().getName());

        try {
            John.getPet().feed();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        John.getPet().walk(9.0);
        System.out.println(John.getPet().getWeight());
        try {
            John.getPet().feed();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        John.getPet().walk(9.0);
        System.out.println(John.getPet().getWeight());
        try {
            John.getPet().feed();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        Car porsche = new Car("911", "Porsche", 5.0, ENGINE.BENZIN);
        John.setCar(porsche);

        System.out.println("1"); // flag for checking if each exception was caught.

        System.out.println(John.getCar().getProducer() + " " + John.getCar().getModel());
    }
}
