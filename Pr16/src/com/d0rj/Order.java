package com.d0rj;


public interface Order {

    boolean add(Item item);
    boolean removeByName(String name);
    int removeAllByName(String name);
    int getCount();
    Item[] toArray();
    int getOrderPrice();
    int countOf(String name);
    String[] allNames();
    Item[] toSortedArray();
}
