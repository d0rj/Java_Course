package com.d0rj;

import com.d0rj.exception.InvalidInnException;
import com.d0rj.inn.EntityInnChecker;
import com.d0rj.inn.IndividualInnChecker;
import com.d0rj.interfaces.IInnChecker;


public class Shop {

    public void checkout(String inn) throws InvalidInnException {
        IInnChecker checker = new EntityInnChecker();
        if (checker.isCorrectInn(inn)) {
            System.out.println("ИНН для юридического лица корректно.");
            return;
        }

        checker = new IndividualInnChecker();
        if (checker.isCorrectInn(inn)) {
            System.out.println("ИНН для физического лица корректно.");
        }

        throw new InvalidInnException();
    }
}
