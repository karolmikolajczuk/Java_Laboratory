package devices;

import com.karolmikolajczuk.ENGINE;
import com.karolmikolajczuk.Human;
import com.karolmikolajczuk.Sellable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public abstract class Car extends Device implements Sellable, Comparable<Car>, Comparator<Car> {

    private String model;
    private Double engine_size;
    private ENGINE engine;
    public BigDecimal fuel_state; // 0 - 100

    private List<Human> owners;
    private List<Transaction> transactions;

    public Car() {
        this.model = "";
        this.engine_size = 0.0;
        this.engine = ENGINE.NONE;
        this.value = new BigDecimal("0.0");
        this.fuel_state = new BigDecimal(1.0);

        this.owners = new ArrayList<>();
        this.transactions = new ArrayList<>();
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

        this.owners = new ArrayList<>();
        this.transactions = new ArrayList<>();
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

        // check if declared seller is real seller (owner) of this car
        if (this.getCurrentOwner() != seller) {
            throw new IllegalStateException("He is not current owner of a car.");
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

        // add new owner of a car to history of a car
        this.owners.add(buyer);

        // add transaction to transactions history
        this.transactions.add(new Transaction(seller, buyer, price, new Date()));

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

    /**
     * This method returns whole list of a owners
     * @return list of owners
     */
    public List<Human> getOwners() {
        return owners;
    }

    /**
     * This method set's a new list of car's owners.
     * @param owners the new history of owners.
     */
    public void setOwners(List<Human> owners) {
        this.owners = owners;
    }

    /**
     * This method returns the current owner
     * @return current owner (Human)
     */
    public Human getCurrentOwner() {
        return this.owners.get(this.owners.size()-1);
    }

    /**
     * Adding new owner to a cars owners history
     * @param new_owner new owner of a car
     */
    public void addNewOwner(Human new_owner) {
        // is instance of if (new_owner)
        this.owners.add(new_owner);
    }

    /**
     * This method gives possibility to check if some human was previously
     *  an owner of this car.
     * @param previous_owner some human to check
     * @return true if he was previously an owner, false if not.
     */
    public boolean checkIfHumanWasPreviouslyOwner(Human previous_owner) {
        return this.owners.contains(previous_owner);
    }

    /**
     * This method checks if Human a sold a Car to Human b.
     * @param a Human a
     * @param b Human b
     * @return true if a sold car to b, false if not.
     */
    public boolean checkIfHumanASoldCarToHumanB(Human a, Human b) throws IllegalArgumentException {
        if (this.owners.contains(a) && this.owners.contains(b))
            return this.owners.indexOf(b) - this.owners.indexOf(a) == 1;

        throw new IllegalArgumentException("Some human was not an owner.");
    }

    /**
     * This method return number of transactions that he was included.
     * Simply, its just a number of owners, cause even first owner had to buy it
     * from carshop, so there was a 1 transaction. If it has 2 owners, then it
     * had 2 transactions made, cause from carshop to owner#1 and transaction
     * between owner#1 and owner#2.
     * @return number of transactions
     */
    public int getHowManyTransactionsWereMadeOnThisCar() {
        return this.transactions.size();
    }
    /**
     *
     */
    public abstract void refuel();
}
