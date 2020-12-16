package com.d0rj;


public class Plate extends Dish {

    private final String size;


    public Plate(String material, String color, String size) {
        super(material, color);
        this.size = size;
    }


    @Override
    public void setColor(String color) {
        // null
    }


    @Override
    public String toString() {
        return "Plate {" +
                "size='" + size + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                "} " + super.toString();
    }
}
