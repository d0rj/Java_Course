package com.d0rj;


@FunctionalInterface
public interface IItemSelector<E> {

    boolean selectIt(E item);
}
