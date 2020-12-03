package com.d0rj.cafe.exceptions;


public class OrderAlreadyAddedException extends Exception {

    public OrderAlreadyAddedException() {
        super("Order already added.");
    }
}
