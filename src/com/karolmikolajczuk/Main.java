package com.karolmikolajczuk;

import com.sun.security.jgss.GSSUtil;
import devices.Benzin;
import devices.Car;
import devices.ORDER;
import devices.Phone;

import java.io.File;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Human human_1 = new Human(
                "Test1",
                "Test1",
                22.2,
                new Phone(123456789, "T-MOBILE"),
                null,
                6,
                new Car("911", "PORSCHE", 3.0, ENGINE.BENZIN, new BigDecimal(100000), 2010) {
                    @Override
                    public void refuel() {
                        this.fuel_state =
                            this.fuel_state.add(
                                new BigDecimal(
                                100.0 - this.fuel_state.doubleValue()));
                    }
                }
        );
        human_1.addMoney(1000.0);
        human_1.setSalary(2000000.0);
        System.out.println(human_1.howManyCarsInGarage());

        System.out.println(human_1.getGarageSize());
        System.out.println(human_1.getCar(0));

        human_1.setCar(new Car("912", "PORSCHE", 3.0, ENGINE.BENZIN, new BigDecimal(100000), 2012) {
                @Override
                public void refuel() {
                    this.fuel_state =
                    this.fuel_state.add(
                        new BigDecimal(
                        100.0 - this.fuel_state.doubleValue()));
                }
            }
        );

        System.out.println(human_1.howManyCarsInGarage());
        System.out.println(human_1.getGarageSize());
        System.out.println(human_1.getCar(1));

        Human human_2 = new Human(
                "Test1",
                "Test1",
                22.2,
                new Phone(123456789, "T-MOBILE"),
                null,
                6,
                new Car("913", "PORSCHE", 3.0, ENGINE.BENZIN, new BigDecimal(100000), 2008) {
                    @Override
                    public void refuel() {
                        this.fuel_state =
                                this.fuel_state.add(
                                        new BigDecimal(
                                                100.0 - this.fuel_state.doubleValue()));
                    }
                }
        );
        human_2.addMoney(1000.0);
        human_2.setSalary(30000000.0);
        human_2.getCar(0).sell(human_2, 0, human_1, new BigDecimal(1));

        System.out.println(human_2.getGarageSize());
        System.out.println(human_1.getGarageSize());
        System.out.println(human_1.howManyCarsInGarage());
        System.out.println(human_2.howManyCarsInGarage());
        System.out.println(human_1.getCar(2));

        System.out.println(human_1.getCar(0).getYear());
        System.out.println(human_1.getCar(1).getYear());
        System.out.println(human_1.getCar(2).getYear());

        human_1.sortCarsInGarage(ORDER.ASCENDING);

        System.out.println(human_1.getCar(0).getYear());
        System.out.println(human_1.getCar(1).getYear());
        System.out.println(human_1.getCar(2).getYear());

        human_1.sortCarsInGarage(ORDER.DESCENDING);

        System.out.println(human_1.getCar(0).getYear());
        System.out.println(human_1.getCar(1).getYear());
        System.out.println(human_1.getCar(2).getYear());

        System.out.println(human_1.getCar(2).getCurrentOwner());
        try {
            System.out.println(human_1.getCar(2).checkIfHumanASoldCarToHumanB(human_2, human_1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(human_1.getCar(2).checkIfHumanWasPreviouslyOwner(human_2));

    }
}
