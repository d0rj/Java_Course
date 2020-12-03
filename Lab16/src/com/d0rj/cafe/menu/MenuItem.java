package com.d0rj.cafe.menu;


public class MenuItem {

    private int cost;
    private String name;
    private String description;


    public MenuItem(int cost, String name, String description) throws IllegalArgumentException {
        if (cost < 0)
            throw new IllegalArgumentException("Cost must be non-negative.");
        if (name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("MenuItem's name must be non-empty.");
        if (description.isEmpty() || description.isBlank())
            throw new IllegalArgumentException("MenuItem's description must be non-empty.");

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
