package com.d0rj;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        String inputString;
        var scanner = new Scanner(System.in);
        FileRewriter rewriter;

        System.out.println("Input file name: ");
        inputString = scanner.nextLine();
        try {
            rewriter = new FileRewriter(inputString);
        }
        catch (IOException e) {
            System.out.println("File does not exists.");
            return;
        }

        inputString = scanner.nextLine();
        try {
            rewriter.rewrite(inputString);
        }
        catch (IOException e) {
            System.out.println("Some errors with I/O.");
        }

        rewriter.close(); // Throws Exception
    }
}
