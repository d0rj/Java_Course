package com.d0rj.task3;


public class TestShirt {

    private static final String[] shirts = new String[]{
            "S001,Black Polo Shirt,Black,XL",
            "S002,Black Polo Shirt,Black,L",
            "S003,Blue Polo Shirt,Blue,XL",
            "S004,Blue Polo Shirt,Blue,M",
            "S005,Tan Polo Shirt,Tan,XL",
            "S006,Black T-Shirt,Black,XL",
            "S007,White T-Shirt,White,XL",
            "S008,White T-Shirt,White,L",
            "S009,Green T-Shirt,Green,S",
            "S010,Orange T-Shirt,Orange,S",
            "S011,Maroon Polo Shirt,Maroon,S"
    };


    public static void main(String[] args) {
        var shirtsObj = new Shirt[shirts.length];
        for (int i = 0; i < shirts.length; ++i)
            shirtsObj[i] = Shirt.fromString(shirts[i]);

        for (var shirt : shirtsObj)
            System.out.println(shirt);
    }
}
