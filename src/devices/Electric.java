package devices;

import com.karolmikolajczuk.ENGINE;

import java.math.BigDecimal;

public class Electric extends Car {
    public Electric() {
    }

    public Electric(String model, String producer, Double engine_size, ENGINE engine, BigDecimal value) {
        super(model, producer, engine_size, engine, value);
    }

    @Override
    public void refuel() {
        System.out.println("Charging car.");
    }

    @Override
    public String toString() {
        return "Electric car: " + super.toString();
    }
}
