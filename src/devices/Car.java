package devices;

import com.karolmikolajczuk.ENGINE;
import com.karolmikolajczuk.Human;
import com.karolmikolajczuk.Sellable;

import java.math.BigDecimal;
import java.util.Comparator;

public abstract class Car extends Device implements Sellable, Comparable<Car>, Comparator<Car> {

    private String model;
    private Double engine_size;
    private ENGINE engine;
    public BigDecimal fuel_state; // 0 - 100

    public Car() {
        this.model = "";
        this.engine_size = 0.0;
        this.engine = ENGINE.NONE;
        this.value = new BigDecimal("0.0");
        this.fuel_state = new BigDecimal(1.0);
    }

    /**
     * Constructor with all parameters
     * @param model Car's model name
     * @param producer Car's producer
     * @param engine_size Car's engine size
     * @param engine Car's engine type
     * @param value Car's value
     */
    public Car(String model, String producer, Double engine_size, ENGINE engine, BigDecimal value, int year) {
        super(producer, 2000, false);
        this.model = model;
        this.engine_size = engine_size;
        this.engine = engine;
        this.value = value;
        this.fuel_state = new BigDecimal(1.0);
        this.year_of_production = year;
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
    public boolean sell(Human seller, int index, Human buyer, BigDecimal price) {
        // check if seller has a car
        if (seller.getCar(index) == null) {
            throw new IllegalStateException("He doesn't have a car. It's scam.");
        }

        // check if buyer has money for car
        if (buyer.getMoney() < price.doubleValue()) {
            throw new IllegalArgumentException("He doesn't have money. It's a cheater.");
        }

        // check if buyer has free space in garage
        if (buyer.howManyCarsInGarage() == buyer.getGarageSize()) {
            throw new IllegalStateException("Buyer doesnt have free space in garage.");
        }

        // set car in buyer's garage
        buyer.setCar(seller.getCar(index));
        // delete car from seller's garage
        seller.deleteCar(index);

        // add money for seller
        seller.addMoney(price.doubleValue());

        // distract money from buyer
        buyer.addMoney(price.doubleValue() * -1);

        // success
        System.out.println("Transaction between " + seller + " and " + buyer + " is done successfully.");

        return true;
    }

    @Override
    public boolean sell(Human seller, Human buyer, BigDecimal price) {
        return false;
    }

    @Override
    public int compareTo(Car o) {
        System.out.println(this.toString());
        System.out.println(o.toString());

        if (o == null) return this.year_of_production;
        return this.year_of_production - o.year_of_production;
    }

    @Override
    public int compare(Car o1, Car o2) {
        System.out.println(o1.toString());
        System.out.println(o2.toString());

        if (o1 == null && o2 != null) return o2.year_of_production;
        if (o2 == null && o1 != null) return o1.year_of_production;
        if (o1 == null && o2 == null) return 0;

        return o1.year_of_production - o2.year_of_production;
    }

    /**
     * This method returns the year of production of a car
     * @return year of production of a car
     */
    public int getYear() {
        return this.year_of_production;
    }

    public abstract void refuel();
}
