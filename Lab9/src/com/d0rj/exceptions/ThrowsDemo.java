package com.d0rj.exceptions;

import java.util.Scanner;


public class ThrowsDemo {

    public void getKey() {
        var scanner = new Scanner(System.in);
        var inputting = true;

        while (inputting) {
            try {
                System.out.println("Enter key: ");
                String key = scanner.nextLine();
                printMessage(key);
                inputting = false;
            }
            catch (Exception e) {
                System.out.println("Empty key. Try to enter some another.");
            }
        }
    }


    public void printMessage(String key) throws Exception {
        System.out.println(getDetails(key));
    }


    public String getDetails(String key) throws NullPointerException {
        if (key.equals("")) {
            throw new NullPointerException("null key in ThrowsDemo.getDetails");
        }

        return "'" + key + "' is 300$.";
    }
}
