package com.d0rj;


public final class Dish implements Item {

    private final int cost;
    private final String name;
    private final String description;


    public Dish(int cost, String name, String description) throws IllegalArgumentException {
        if (name.equals("") || name.isEmpty() || description.equals("") || description.isEmpty() || cost < 0)
            throw new IllegalArgumentException();

        this.cost = cost;
        this.name = name;
        this.description = description;
    }


    @Override
    public int getCost() {
        return cost;
    }


    @Override
    public String getName() {
        return name;
    }

    
    @Override
    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Dish{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
