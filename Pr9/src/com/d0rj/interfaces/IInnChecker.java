package com.d0rj.interfaces;


import com.d0rj.exception.InvalidInnException;

public interface IInnChecker {

    boolean isCorrectInn(String inn);
    int getDepartmentCode(String inn) throws InvalidInnException;
    int getTaxpayerNumber(String inn) throws InvalidInnException;
}
