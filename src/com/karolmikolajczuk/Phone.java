package com.karolmikolajczuk;

public class Phone {

    private Integer dialling_code;
    private Integer number;
    private String net;

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
}
