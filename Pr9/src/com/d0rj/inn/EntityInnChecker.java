package com.d0rj.inn;

import com.d0rj.exception.InvalidInnException;
import com.d0rj.interfaces.IInnChecker;


public class EntityInnChecker implements IInnChecker {

    @Override
    public boolean isCorrectInn(String inn) {
        if (inn.length() != 10)
            return false;

        var n = new int[10];
        for (int i = 0; i < 10; ++i)
            n[i] = Integer.parseInt(String.valueOf(inn.charAt(i)));

        int controlNum = 2*n[0] + 4*n[1] + 10*n[2] + 3*n[3] + 5*n[4] + 9*n[5] + 4*n[6] + 6*n[7] + 8*n[8];
        controlNum %= 11;
        controlNum %= 10;

        return controlNum == n[9];
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

        return Integer.parseInt(inn.substring(4, 9));
    }
}
