package com.d0rj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        var list = new ArrayList<Integer>();
        var reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++)
            list.add(Integer.parseInt(reader.readLine()));

        System.out.print(sum(list));
    }


    public static int sum(ArrayList<Integer> list)
    {
        int sum = 0;
        for (var num : list)
            sum += num;

        return sum;
    }
}

