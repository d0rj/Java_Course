package com.d0rj;


public final class Drink {

    private final int cost;
    private final String name;
    private final String description;

    public static final int DEFAULT_COST = 0;


    public Drink(String name, String description) {
        this.cost = DEFAULT_COST;
        this.name = name;
        this.description = description;
    }


    public Drink(int cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
