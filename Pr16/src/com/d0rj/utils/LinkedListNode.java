package com.d0rj.utils;


public class LinkedListNode<T> {

    private T data;
    private LinkedListNode<T> prev;
    private LinkedListNode<T> next;


    public LinkedListNode(T data) {
        this.data = data;
    }


    public LinkedListNode(T data, LinkedListNode<T> prev, LinkedListNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }


    public T getData() {
        return data;
    }

    public LinkedListNode<T> getPrev() {
        return prev;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }


    public void setData(T data) {
        this.data = data;
    }

    public void setPrev(LinkedListNode<T> prev) {
        this.prev = prev;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
}
