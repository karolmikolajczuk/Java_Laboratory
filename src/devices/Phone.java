package devices;

import com.karolmikolajczuk.Human;
import com.karolmikolajczuk.Sellable;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

public class Phone extends Device implements Sellable {

    private Integer dialling_code;
    private Integer number;
    private String net;

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final String PROTOCOL = "TCPiP";
    private static final String VERSION = "IPv4";

    public Phone() {
        this.dialling_code = 0;
        this.number = 0;
        this.net = "";
    }

    public Phone(Integer number, String net) {
        this.dialling_code = -1;
        this.number = number;
        this.net = net;
    }

    public Phone(Integer number, String net, Integer dialling_code) {
        this.dialling_code = dialling_code;
        this.number = number;
        this.net = net;
    }

    public void setDialling_code(Integer dialling_code) {
        this.dialling_code = dialling_code;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public Integer getDialling_code() {
        return dialling_code;
    }

    public Integer getNumber() {
        return number;
    }

    public String getNet() {
        return net;
    }

    @Override
    public boolean equals(Object obj) {
        Phone p = (Phone) obj;
        return this.number.equals(p.number) &&
                this.dialling_code.equals(p.dialling_code) &&
                this.net.equals(p.net);
    }

    @Override
    public String toString() {
        return this.number.toString();
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
        if (seller.getNumber() == null)  {
            System.out.println("He doesn't have a phone. It's scam.");
            return false;
        }
        if (buyer.getMoney() < price.doubleValue()) {
            System.out.println("He doesn't have money. It's a cheater.");
            return false;
        }

        buyer.addMoney(price.doubleValue() * -1);
        seller.addMoney(price.doubleValue());

        buyer.setNumber(seller.getNumber());
        seller.setNumber(null);
        System.out.println("Transaction between " + seller + " and " + buyer + " is done successfully.");

        return true;
    }

    @Override
    public boolean sell(Human seller, int index, Human buyer, BigDecimal price) {
        return false;
    }

    public void installAnApp(String app_name) {
        System.out.println("Installing an app: " + app_name);
    }

    public void installAnApp(String app_name, Double version) {
        System.out.println("Installing " + version.doubleValue() +
                " version of an app: " + app_name);
    }

    public void installAnApp(String app_name, Double version, String address) {
        System.out.println("Installing " + version.doubleValue() +
                " version of an app: " + app_name + " from " +
                address);
    }

    public void installAnApp(List<String> app_name) {
        for (int index = 0; index < app_name.size(); ++index) {
            System.out.println("Installing an app: " + app_name);
        }
    }

    public void installAnApp(URL app_name) {
        System.out.println("Installing an app: " + app_name);
    }

}
