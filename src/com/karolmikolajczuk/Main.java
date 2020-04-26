package com.karolmikolajczuk;

import java.io.File;
import java.math.BigDecimal;

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

        John.setSalary(3000.0);

        System.out.println(John.getSalary());
        try {
            John.raiseSalary(500.0);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(John.getSalary());

        Car porsche = new Car("911", "Porsche", 5.0, ENGINE.BENZIN, new BigDecimal("1000.0"));
        John.setCar(porsche);
        System.out.println("1"); // flag for checking if each exception was caught.


    }
}
