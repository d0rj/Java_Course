package com.d0rj;


public class ElementGetter {

    private ElementGetter() {
    }

    public static <E> E GetElementAt(E[] arr, int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= arr.length)
            throw new ArrayIndexOutOfBoundsException();

        return arr[index];
    }
}
