package com.d0rj.task3;


public class Shirt {

    private final int index;
    private final String name;
    private final String color;
    private final String size;


    public Shirt(int index, String name, String color, String size) {
        this.index = index;
        this.name = name;
        this.color = color;
        this.size = size;
    }


    public static Shirt fromString(String src) throws IllegalArgumentException {
        String[] tokens = src.split(",");

        if (tokens.length != 4)
            throw new IllegalArgumentException();

        tokens[0] = tokens[0].replace('S', '0');

        return new Shirt(
            Integer.parseInt(tokens[0]),
            tokens[1],
            tokens[2],
            tokens[3]
        );
    }


    @Override
    public String toString() {
        return "Shirt{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
