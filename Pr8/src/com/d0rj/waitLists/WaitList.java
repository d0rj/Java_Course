package com.d0rj.waitLists;

import com.d0rj.interfaces.IWaitList;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;


public class WaitList<E> implements IWaitList<E> {

    protected ConcurrentLinkedQueue<E> content;


    public WaitList() {
        content = new ConcurrentLinkedQueue<>();
    }


    public WaitList(Collection<E> c) {
        content = new ConcurrentLinkedQueue<>(c);
    }


    @Override
    public void add(E element) {
        content.add(element);
    }


    @Override
    public E remove() {
        return content.remove();
    }


    @Override
    public boolean contains(E element) {
        return content.contains(element);
    }


    @Override
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }


    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }


    @Override
    public String toString() {
        return "WaitList{" +
                "content=" + content +
                '}';
    }
}
