package com.jplsw.coffeeclicker.common;

import java.util.Date;

public class Drink {

    private float amount;

    // Time in format hh-mm-ss
    private String timeConsumed;

    public Drink(float amount, String timeConsumed) {
        this.amount = amount;
        this.timeConsumed = timeConsumed;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getTimeConsumed() {
        return timeConsumed;
    }

    public void setTimeConsumed(String timeConsumed) {
        this.timeConsumed = timeConsumed;
    }
}
