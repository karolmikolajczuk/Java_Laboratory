package devices;

import com.karolmikolajczuk.ENGINE;

import java.math.BigDecimal;

public class LPG extends Car {
    public LPG() {
    }

    public LPG(String model, String producer, Double engine_size, ENGINE engine, BigDecimal value) {
        super(model, producer, engine_size, engine, value);
    }

    @Override
    public void refuel() {
        System.out.println("Tanking LPG..");
    }

    @Override
    public String toString() {
        return "LPG car: " + super.toString();
    }
}
