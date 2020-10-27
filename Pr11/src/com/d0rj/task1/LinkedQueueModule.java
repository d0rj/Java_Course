package com.d0rj.task1;


public class LinkedQueueModule<T> {

    private T data;
    private LinkedQueueModule<T> next;
    private LinkedQueueModule<T> prev;


    public LinkedQueueModule(T data) {
        this(data, null, null);
    }


    public LinkedQueueModule(T data, LinkedQueueModule<T> next, LinkedQueueModule<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }


    public T getData() {
        return data;
    }

    public LinkedQueueModule<T> getNext() {
        return next;
    }

    public LinkedQueueModule<T> getPrev() {
        return prev;
    }


    public void setData(T data) {
        this.data = data;
    }

    public void setNext(LinkedQueueModule<T> next) {
        this.next = next;
    }

    public void setPrev(LinkedQueueModule<T> prev) {
        this.prev = prev;
    }
}
