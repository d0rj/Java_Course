package com.d0rj;

import com.d0rj.utils.MyArrayList;


public class Order {

    private MyArrayList<Item> items;


    public boolean add(Item item) {
        return items.add(item);
    }


    public boolean remove(Item item) {
        return items.remove(item);
    }
}
