package com.d0rj;


public final class Dish implements Item {

    private final int cost;
    private final String name;
    private final String description;


    public Dish(int cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }


    @Override
    public int getCost() {
        return 0;
    }


    @Override
    public String getName() {
        return null;
    }

    
    @Override
    public String getDescription() {
        return null;
    }
}
