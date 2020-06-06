package devices;

import com.karolmikolajczuk.Human;
import com.karolmikolajczuk.Sellable;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Phone extends Device implements Sellable {

    private Integer dialling_code;
    private Integer number;
    private String net;

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final String PROTOCOL = "TCPiP";
    private static final String VERSION = "IPv4";

    List<Application> installed_applications;

    public Phone() {
        this.dialling_code = 0;
        this.number = 0;
        this.net = "";
        this.installed_applications = new ArrayList<>();
    }

    public Phone(Integer number, String net) {
        this.dialling_code = -1;
        this.number = number;
        this.net = net;
        this.installed_applications = new ArrayList<>();
    }

    public Phone(Integer number, String net, Integer dialling_code) {
        this.dialling_code = dialling_code;
        this.number = number;
        this.net = net;
        this.installed_applications = new ArrayList<>();
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

    public void installAnApp(Application app) {

        // check if already installed
        if (this.installed_applications.contains(app)) {
            System.out.println("Already installed.");
            return;
        }

        // check if user has older version
        for (Application iter_app : this.installed_applications) {
            if (iter_app.getName().equals(app.getName()) &&
                !(iter_app.getVersion().equals(app.getVersion()))) {
                System.out.println("Installing newer version of an app.");
                this.installed_applications.set(
                    this.installed_applications.indexOf(iter_app), app);
                return;
            }
        }

        this.installed_applications.add(app);
        System.out.println("Installed an app: " + app);
    }

    public boolean checkIfAppInstalled(Application app) {
        return this.installed_applications.contains(app);
    }

    public boolean checkIfAppInstalled(String app_name) {
        for (Application app : this.installed_applications) {
            if (app.getName().equals(app_name)) return true;
        }
        return false;
    }

    public void printFreeInstalledApps() {
        System.out.println("Free apps: ");
        int count = 0;
        for (Application app : this.installed_applications) {
            if (app.getAmount().equals(0)) {
                ++count;
                System.out.println(app.getName());
            }
        }
        System.out.println("Installed: " + count + " free apps.");
    }

    public Double amountInstalledApps() {
        Double amount = 0.0;
        for (Application app : this.installed_applications) {
            amount += app.getAmount();
        }
        return amount;
    }

    public void printAppsLexicographly() {
        this.installed_applications.sort(Comparator.comparing(Application::getName));
        System.out.println("Lexicography order: ");
        printApps();
    }

    public void printAppsFromCheaperToMostExpensive() {
        this.installed_applications.sort((o1, o2) -> {
            // convert into cents - so it can be int value now
            double o1_amount = o1.getAmount() * 100.0;
            double o2_amount = o2.getAmount() * 100.0;

            // sort by values
            return (int) o1_amount - (int) o2_amount;
        });
        System.out.println("From Cheapest to Most Expensive:");
        printApps();
    }

    private void printApps() {
        for (Application app : this.installed_applications) {
            System.out.println(app.getName());
        }
    }
}
