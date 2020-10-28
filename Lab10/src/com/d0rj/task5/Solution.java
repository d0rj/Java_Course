package com.d0rj.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class Solution {

    public static <T> ArrayList<T> newArrayList(T[] src) {
        return new ArrayList<>(Arrays.asList(src));
    }


    public static <T> HashSet<T> newHashSet(T[] src) {
        return new HashSet<>(Arrays.asList(src));
    }


    public static <K, V> HashMap<K, V> newHashMap(K[] keys, V[] values) throws IllegalArgumentException {
        if (keys.length != values.length)
            throw new IllegalArgumentException("Array sizes are different.");

        var result = new HashMap<K, V>();
        for (int i = 0; i < keys.length; ++i) {
            result.put(keys[i], values[i]);
        }

        return result;
    }
}
