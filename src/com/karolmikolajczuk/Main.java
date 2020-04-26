package com.karolmikolajczuk;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Human John = new Human("John", "Doe", 20.0,
                new Phone(123456789, "PLAY"));
        Animal pet = new Animal("Fifi", new File(""));

        System.out.println(John.getName());
        System.out.println(John.getSurname());
        System.out.println(John.getAge());
        System.out.println(John.getNumber().getNumber());

        System.out.println();
        System.out.println(pet.getName());
    }
}
