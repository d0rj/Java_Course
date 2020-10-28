package com.d0rj;


public class Main {

    public static void main(String[] args) {
        var arr = new String[] {"Hi", "my", "name", "is", "hi", "my", "name", "is", "Slim"};
        var nums = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
        var elem = ElementGetter.GetElementAt(arr, 4);
        var num = ElementGetter.GetElementAt(nums, 4);

        System.out.println(elem);
        System.out.println(num);
    }
}
