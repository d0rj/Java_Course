package com.d0rj;

import com.d0rj.utils.ItemsSorter;
import com.d0rj.utils.MyArrayList;


public class RestaurantOrder implements Order {

    private MyArrayList<Item> items;


    public boolean add(Item item) {
        return items.add(item);
    }


    @Override
    public boolean removeByName(String name) {
        for (int i = items.size() - 1; i >= 0; --i)
            if (items.at(i).getName().equals(name)) {
                items.remove(i);
                return true;
            }

        return false;
    }


    @Override
    public int removeAllByName(String name) {
        int count = 0;
        for (var item : items)
            if (item.getName().equals(name))
                ++count;

        items.removeIf(item -> item.getName().equals(name));
        return count;
    }


    @Override
    public int getCount() {
        return items.size();
    }


    @Override
    public Item[] toArray() {
        return (Item[]) items.toArray();
    }


    @Override
    public int getOrderPrice() {
        int result = 0;

        for (var item : items)
            result += item.getCost();

        return result;
    }


    @Override
    public int countOf(String name) {
        int count = 0;

        for (var item : items)
            if (item.getName() == name)
                ++count;

        return count;
    }


    @Override
    public String[] allNames() {
        var names = new MyArrayList<String>();

        for (var item : items)
            if (!names.contains(item.getName()))
                names.add(item.getName());

        return (String[])names.toArray();
    }


    @Override
    public Item[] toSortedArray() {
        Item[] result = (Item[])items.toArray();
        ItemsSorter.sort(result);
        return result;
    }


    public boolean remove(Item item) {
        return items.remove(item);
    }
}
