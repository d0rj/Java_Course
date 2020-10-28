package com.d0rj.task4;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        var elements = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};

        var result = new CatalogToList<>(elements);
    }
}
