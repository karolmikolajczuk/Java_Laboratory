package com.karolmikolajczuk;

import com.sun.security.jgss.GSSUtil;
import devices.*;

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

        human_1.installApp(new Application("GoogleMaps", "0.0.1", 0.0));
        human_1.installApp(new Application("OtoMoto", "0.2.1", 0.50));
        human_1.installApp(new Application("AngryBirds", "1.0", 0.0));
        human_1.installApp(new Application("AngryBirds", "1.0", 0.0));
        human_1.installApp(new Application("AngryBirds", "1.1", 0.0));
        human_1.installApp(new Application("ZOOM", "1.0", 10.0));
        human_1.getNumber().printFreeInstalledApps();
        human_1.getNumber().printAppsLexicographly();
        human_1.getNumber().printAppsFromCheaperToMostExpensive();
        System.out.println(human_1.getNumber().amountInstalledApps());
        System.out.println(human_1.getNumber().checkIfAppInstalled(new Application("AngryBirds", "1.1", 0.0)));
        System.out.println(human_1.getNumber().checkIfAppInstalled("ZOOM"));
    }
}
