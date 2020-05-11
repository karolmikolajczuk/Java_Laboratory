package devices;

public class Phone extends Device {

    private Integer dialling_code;
    private Integer number;
    private String net;

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
}
