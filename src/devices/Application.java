package devices;

public class Application {
    private String name;
    private String version;
    private Double amount;

    public Application(String name, String version, Double amount) {
        this.name = name;
        this.version = version;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object obj) {
        Application app = (Application) obj;
        return this.name.equals(app.getName()) &&
                this.version.equals(app.getVersion()) &&
                this.amount.equals(app.getAmount());
    }
}
