package com.d0rj;

public class Main {

    public static void main(String[] args) {
	    var myArray = new MyArrayList2<Integer>(10);

	    myArray.add(1);

	    for (int i = 0; i < myArray.size(); ++i)
            System.out.println(myArray.get(i));
    }
}
