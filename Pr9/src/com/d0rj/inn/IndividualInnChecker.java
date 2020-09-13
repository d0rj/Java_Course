package com.d0rj.inn;

import com.d0rj.exception.InvalidInnException;
import com.d0rj.interfaces.IInnChecker;


public class IndividualInnChecker implements IInnChecker {

    @Override
    public boolean isCorrectInn(String inn) {
        if (inn.length() != 12)
            return false;

        var n = new int[10];
        for (int i = 0; i < 10; ++i)
            n[i] = Integer.parseInt(String.valueOf(inn.charAt(i)));

        int n11 = 7*n[0] + 2*n[1] + 4*n[2] + 10*n[3] + 3*n[4] + 5*n[5] + 9*n[6] + 4*n[7] + 6*n[8] + 8*n[9];
        n11 %= 11;
        n11 %= 10;

        int n12 = 3*n[0] + 7*n[1] + 2*n[2] + 4*n[3] + 10*n[4] + 3*n[5] + 5*n[6] + 9*n[7] + 4*n[8] + 6*n[9] + 8*n11;
        n12 %= 11;
        n12 %= 10;

        return (n11 == Integer.parseInt(String.valueOf(inn.charAt(10))) &&
                n12 == Integer.parseInt(String.valueOf(inn.charAt(11))));
    }


    @Override
    public int getDepartmentCode(String inn) throws InvalidInnException {
        if (!isCorrectInn(inn))
            throw new InvalidInnException();

        return Integer.parseInt(inn.substring(0, 4));
    }


    @Override
    public int getTaxpayerNumber(String inn) throws InvalidInnException {
        if (!isCorrectInn(inn))
            throw new InvalidInnException();

        return Integer.parseInt(inn.substring(4, 10));
    }
}
