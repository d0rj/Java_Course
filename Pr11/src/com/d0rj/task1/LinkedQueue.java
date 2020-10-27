package com.d0rj.task1;


public class LinkedQueue<E> implements IQueue<E> {

    private LinkedQueueModule<E> head;


    public void Enqueue(E element) {
        if (head == null) {
            head = new LinkedQueueModule<>(element);
            return;
        }

        LinkedQueueModule<E> prevModule = head;
        while (prevModule.getPrev() != null)
            prevModule = prevModule.getPrev();

        prevModule.setPrev(new LinkedQueueModule<>(element, prevModule, null));
    }


    public final E Element() {
        return head.getData();
    }


    public E Dequeue() {
        if (head == null)
            return null;

        E result = head.getData();

        head = head.getPrev();
        if (head != null)
            head.setNext(null);

        return result;
    }


    public final int Size() {
        int result = 0;

        var elem = head;
        while (elem != null) {
            ++result;
            elem = elem.getPrev();
        }

        return result;
    }


    public final boolean IsEmpty() {
        return head == null;
    }


    public void Clear() {
        head = null;
    }
}
