package com.jplsw.coffeeclicker.common;

public class Statistic {

    private int date;
    private int coffeeCount;
    private int energyCount;

    public Statistic(int date, int coffeeCount, int energyCount) {
        this.date = date;
        this.coffeeCount = coffeeCount;
        this.energyCount = energyCount;
    }

    public String toString() {
        return "" + date + "; " + coffeeCount + "; " + energyCount;
    }
}
