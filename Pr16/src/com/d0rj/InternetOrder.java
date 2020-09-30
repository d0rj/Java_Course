package com.d0rj;

import com.d0rj.utils.CycledLinkedList;
import com.d0rj.utils.MyArrayList;


public class InternetOrder extends CycledLinkedList<Item> {

    public Item[] select(IItemSelector<Item> selector) {
        var result = new MyArrayList<Item>();

        for (int i = 0; i < size; ++i) {
            if (selector.selectIt(next()))
                result.add(current.getData());
        }

        return (Item[])result.toArray();
    }


    public int countOf(IItemSelector<Item> selector) {
        int count = 0;

        for (int i = 0; i < size; ++i)
            if (selector.selectIt(next()))
                ++count;

        return count;
    }


    public String[] allNames() {
        Item[] items = toArray();
        var result = new MyArrayList<String>(items.length);

        for (int i = 0; i < items.length; ++i)
            if (!result.contains(items[i].getName()))
                result.add(items[i].getName());

        return (String[])result.toArray();
    }
}
