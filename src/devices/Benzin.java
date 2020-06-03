package devices;

import com.karolmikolajczuk.ENGINE;

import java.math.BigDecimal;

public class Benzin extends Car {
    public Benzin() {
    }

    public Benzin(String model, String producer, Double engine_size, ENGINE engine, BigDecimal value, int year) {
        super(model, producer, engine_size, engine, value, year);
    }

    @Override
    public void refuel() {
        System.out.println("Tanking Benzin..");
    }

    @Override
    public String toString() {
        return "Benzin car: " + super.toString();
    }
}
