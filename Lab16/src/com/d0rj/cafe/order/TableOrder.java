package com.d0rj.cafe.order;

import com.d0rj.cafe.menu.MenuItem;
import com.d0rj.cafe.interfaces.Order;
import com.d0rj.cafe.utils.ArrayList;


public class TableOrder implements Order {

    private Customer customer;
    private ArrayList<MenuItem> items = new ArrayList<>();


    public TableOrder() {

    }


    public TableOrder(Customer customer) {
        this.customer = customer;
    }


    @Override
    public boolean add(MenuItem item) {
        return items.add(item);
    }


    @Override
    public String[] itemsNames() {
        var result = new String[items.size()];
        for (int i = 0; i < items.size(); ++i)
            result[i] = items.at(i).getName();

        return result;
    }


    @Override
    public int itemsQuantity() {
        var result = 0;
        for (var item : items)
            result += item.getCost();

        return result;
    }


    @Override
    public int itemQuantity(String itemName) {
        var result = 0;
        for (var item : items)
            if (item.getName().equals(itemName))
                result += item.getCost();
        return result;
    }


    @Override
    public int itemQuantity(MenuItem item) {
        var result = 0;
        for (var i : items)
            if (i.equals(item))
                result += item.getCost();
        return result;
    }


    @Override
    public MenuItem[] getItems() {
        return (MenuItem[]) items.toArray();
    }


    @Override
    public boolean remove(String itemName) {
        return items.removeIf((item) -> item.getName().equals(itemName));
    }


    @Override
    public boolean remove(MenuItem item) {
        return items.removeIf((i) -> i.equals(item));
    }


    @Override
    public int removeAll(String itemName) {
        var result = 0;
        for (var item : items)
            if (item.getName().equals(itemName))
                ++result;

        remove(itemName);
        return result;
    }


    @Override
    public int removeAll(MenuItem item) {
        var result = 0;
        for (var i : items)
            if (i.equals(item))
                ++result;

        remove(item);
        return result;
    }


    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        return new MenuItem[0];
    }


    @Override
    public int costTotal() {
        return itemsQuantity();
    }


    @Override
    public Customer getCustomer() {
        return customer;
    }


    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
