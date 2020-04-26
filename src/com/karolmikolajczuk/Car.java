package com.karolmikolajczuk;

public class Car {

    private String model;
    private String producer;
    private Double engine_size;
    private ENGINE engine;

    /**
     * Constructor with all parameters
     * @param model Car's model name
     * @param producer Car's producer
     * @param engine_size Car's engine size
     * @param engine Car's engine type
     */
    public Car(String model, String producer, Double engine_size, ENGINE engine) {
        this.model = model;
        this.producer = producer;
        this.engine_size = engine_size;
        this.engine = engine;
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
}
