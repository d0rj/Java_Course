package com.d0rj;

public class Main {

    public static void main(String[] args) {
	    var myArray = new MyArrayList<Integer>(10);

	    myArray.add(1);

	    for (int i = 0; i < 15; ++i)
	        myArray.add(i);

        System.out.println("### Перебор по индексам");
	    for (int i = 0; i < myArray.size(); ++i)
            System.out.println(myArray.get(i));

        System.out.println("### Перебор через итератор");
        for (var i : myArray)
            System.out.println(i);

        myArray.remove((Object)1);
        myArray.remove((Object)1);
        myArray.remove(5);
        System.out.println("### Удаление");
        for (var i : myArray)
            System.out.println(i);
    }
}
