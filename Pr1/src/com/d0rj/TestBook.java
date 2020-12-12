package com.d0rj;


public class TestBook {

    public static void main(String[] args) {
        var book1 = new Book("Гераклит", "Мартин Хайдеггер", 1943, 800.5);

        System.out.printf(book1.toString());
    }
}
