package com.d0rj.task1;


public class ArrayQueueModule<T> {

    private T data;
    private ArrayQueueModule<T> next;
    private ArrayQueueModule<T> prev;


    public ArrayQueueModule(T data) {
        this(data, null, null);
    }


    public ArrayQueueModule(T data, ArrayQueueModule<T> next, ArrayQueueModule<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }


    public T getData() {
        return data;
    }

    public ArrayQueueModule<T> getNext() {
        return next;
    }

    public ArrayQueueModule<T> getPrev() {
        return prev;
    }


    public void setData(T data) {
        this.data = data;
    }

    public void setNext(ArrayQueueModule<T> next) {
        this.next = next;
    }

    public void setPrev(ArrayQueueModule<T> prev) {
        this.prev = prev;
    }
}
