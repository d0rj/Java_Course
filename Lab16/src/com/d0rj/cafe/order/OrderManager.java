package com.d0rj.cafe.order;

import com.d0rj.cafe.interfaces.Order;
import com.d0rj.cafe.menu.MenuItem;

import java.util.HashMap;


public class OrderManager<T extends Order> {

    private HashMap<String, T> orders = new HashMap<>();


    public void add(T order, String address) {
        orders.put(address, order);
    }


    public void addItem(MenuItem item, String address) {
        orders.get(address).add(item);
    }


    public T getOrder(String address) {
        return orders.get(address);
    }


    public void remove(String address) {
        orders.remove(address);
    }


    public int removeAll() {
        var result = orders.size();

        orders = new HashMap<>();

        return result;
    }


    public int itemsQuantity(String itemName) {
        var result = 0;

        for (var order : orders.values())
            result += order.itemQuantity(itemName);

        return result;
    }


    public T[] getOrders() {
        return (T[]) orders.values().toArray(new Order[0]);
    }


    public int ordersCost() {
        var result = 0;

        for (var order : orders.values())
            result += order.costTotal();

        return result;
    }
}
