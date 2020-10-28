package com.d0rj.task5;


public class Main {

    public static void main(String[] args) {
        var arr = new String[] {"Hi", "my", "name", "is", "hi", "my", "name", "is", "Slim"};
        var nums = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8};

        var listOfNums = Solution.newArrayList(nums);
        var hashSet = Solution.newHashSet(arr);
        var hashMap = Solution.newHashMap(arr, nums);

        System.out.println(listOfNums);
        System.out.println(hashSet);
        System.out.println(hashMap);
    }
}
