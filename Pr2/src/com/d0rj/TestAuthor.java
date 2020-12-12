package com.d0rj;


public class TestAuthor {

    public static void main(String[] args) {
        var author1 = new Author("А.Г. Дугин", "evrazist.gmail.com", 'm');
        var author2 = new Author("Б-А Леви", "levi@global.com", 't');

        System.out.println(author1.toString());
        System.out.println(author2.toString());
    }
}
