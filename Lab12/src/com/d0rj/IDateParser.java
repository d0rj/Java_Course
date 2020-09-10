package com.d0rj;


public interface IDateParser {

    boolean isDate(String str);
    MyDate parse(String str);
}
