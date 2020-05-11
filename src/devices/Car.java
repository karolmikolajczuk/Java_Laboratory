package devices;

import com.karolmikolajczuk.ENGINE;
import com.karolmikolajczuk.Human;
import com.karolmikolajczuk.Sellable;

import java.math.BigDecimal;

public class Car extends Device implements Sellable {

    private String model;
    private Double engine_size;
    private ENGINE engine;
    private BigDecimal value;

    public Car() {
        this.model = "";
        this.engine_size = 0.0;
        this.engine = ENGINE.NONE;
        this.value = new BigDecimal("0.0");
    }

    /**
     * Constructor with all parameters
     * @param model Car's model name
     * @param producer Car's producer
     * @param engine_size Car's engine size
     * @param engine Car's engine type
     * @param value Car's value
     */
    public Car(String model, String producer, Double engine_size, ENGINE engine, BigDecimal value) {
        super(producer, 2000, false);
        this.model = model;
        this.engine_size = engine_size;
        this.engine = engine;
        this.value = value;
    }

    /**
     * Get present vehicle's model name
     * @return model's name
     */
    public String getModel() {
        return model;
    }

    /**
     * Set model of vehicle
     * @param model new model name
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Get producer name
     * @return producer name
     */
    public String getProducer() {
        return super.producer;
    }

    /**
     * Set producer of vehicle
     * @param producer producer name
     */
    public void setProducer(String producer) {
        super.producer = producer;
    }

    /**
     * Get current engine size
     * @return present engine size
     */
    public Double getEngineSize() {
        return engine_size;
    }

    /**
     * Set new engine size
     * @param engine_size new engine size
     */
    public void setEngineSize(Double engine_size) {
        this.engine_size = engine_size;
    }

    /**
     * Get type of engine
     * @return current engine type
     */
    public ENGINE getEngine() {
        return engine;
    }

    /**
     * Set type of engine
     * @param engine new engine type
     */
    public void setEngine(ENGINE engine) {
        this.engine = engine;
    }

    /**
     * Get a car's value
     * @return current value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Set new value of a car - probably always lower..
     * @param value new car's value
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;
        return this.value.equals(car.value) &&
                this.engine == car.engine &&
                this.engine_size.equals(car.engine_size) &&
                this.model.equals(car.model) &&
                super.producer.equals(car.producer);
    }

    @Override
    public String toString() {
        return super.producer + " " +
                this.model + " with " +
                this.engine_size + " " +
                this.engine + " for " +
                this.value.doubleValue() + " EUR.";
    }

    @Override
    public void turnOn() {
        super.mode = true;
    }

    @Override
    public void turnOff() {
        super.mode = false;
    }

    @Override
    public boolean sell(Human seller, Human buyer, BigDecimal price) {
        if (seller.getCar() == null)  {
            System.out.println("He doesn't have a car. It's scam.");
            return false;
        }
        if (buyer.getMoney() < price.doubleValue()) {
            System.out.println("He doesn't have money. It's a cheater.");
            return false;
        }

        buyer.addMoney(price.doubleValue() * -1);
        seller.addMoney(price.doubleValue());

        buyer.setCar(seller.getCar());
        seller.setCar(null);
        System.out.println("Transaction between " + seller + " and " + buyer + " is done successfully.");

        return true;
    }
}
