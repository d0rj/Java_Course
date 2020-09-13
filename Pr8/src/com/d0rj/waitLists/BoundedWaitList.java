package com.d0rj.waitLists;


/**
 * WaitList with limited capacity.
 * @param <E> - type of elements in queue
 */
public class BoundedWaitList<E> extends WaitList<E> {

    private final int capacity;


    public BoundedWaitList(int capacity) {
        super();
        this.capacity = capacity;
    }


    /**
     * Inserts element at the tail of queue. This waitlist has limited capacity
     * @param element - element to try to insert
     * @throws ArrayIndexOutOfBoundsException if the capacity does not allow to insert more
     */
    @Override
    public void add(E element) throws ArrayIndexOutOfBoundsException {
        if (content.size() < capacity)
            content.add(element);
        else
            throw new ArrayIndexOutOfBoundsException();
    }


    public int getCapacity() {
        return capacity;
    }


    @Override
    public String toString() {
        return "BoundedWaitList{" +
                "capacity=" + capacity +
                ", content=" + content +
                '}';
    }
}
