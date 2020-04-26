package devices;

import com.karolmikolajczuk.ENGINE;

import java.math.BigDecimal;

public class Car {

    private String model;
    private String producer;
    private Double engine_size;
    private ENGINE engine;
    private BigDecimal value;

    public Car() {
        this.model = "";
        this.producer = "";
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
        this.model = model;
        this.producer = producer;
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
        return producer;
    }

    /**
     * Set producer of vehicle
     * @param producer producer name
     */
    public void setProducer(String producer) {
        this.producer = producer;
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
                this.producer.equals(car.producer);
    }

    @Override
    public String toString() {
        return this.producer + " " +
                this.model + " with " +
                this.engine_size + " " +
                this.engine + " for " +
                this.value.doubleValue() + " EUR.";
    }
}
