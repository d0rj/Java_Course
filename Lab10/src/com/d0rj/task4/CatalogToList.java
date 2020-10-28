package com.d0rj.task4;

import java.util.ArrayList;
import java.util.List;


public class CatalogToList<T> {

    private ArrayList<T> list;


    public CatalogToList(List<?> catalog) {
        list = new ArrayList<>();

        for (var element : catalog)
            list.add((T)element);

        System.out.println("Первые 4 элемента: ");
        for (int i = 0; i < list.size(); ++i)
            if (i < 4)
                System.out.println("\t" + list.get(i));
    }


    public ArrayList<T> getList() {
        return list;
    }
}
