package com.d0rj;

import com.d0rj.interfaces.IWaitList;
import com.d0rj.waitLists.BoundedWaitList;
import com.d0rj.waitLists.UnfairWaitList;


public class Main {

    public static void main(String[] args) {
        System.out.println("### Testing BoundedWaitList ###");
        testBounded();

        System.out.println("### Testing UnfairWaitList ###");
        testUnfair();
    }


    private static void testBounded() {
        IWaitList<Integer> waitList = new BoundedWaitList<>(10);

        try {
            for (var i : new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12})
                waitList.add(i);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds.");
        }

        printWaitList(waitList);
    }


    private static void testUnfair() {
        IWaitList<Integer> waitList = new UnfairWaitList<>();

        for (var i : new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 1, 2})
            waitList.add(i);

        ((UnfairWaitList<Integer>)waitList).moveToBack(1);

        printWaitList(waitList);
    }


    private static <E> void printWaitList(IWaitList<E> waitList) {
        while (!waitList.isEmpty())
            System.out.println(waitList.remove());
    }
}
