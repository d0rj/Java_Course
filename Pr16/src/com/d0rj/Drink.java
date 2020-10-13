package com.d0rj;


public final class Drink implements Item {

    private final int cost;
    private final String name;
    private final String description;

    public static final int DEFAULT_COST = 0;


    public Drink(String name, String description) throws IllegalArgumentException {
        if (name.equals("") || name.isEmpty() || description.equals("") || description.isEmpty())
            throw new IllegalArgumentException();

        this.cost = DEFAULT_COST;
        this.name = name;
        this.description = description;
    }


    public Drink(int cost, String name, String description) {
        if (name.equals("") || name.isEmpty() || description.equals("") || description.isEmpty() || cost < 0)
            throw new IllegalArgumentException();

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
