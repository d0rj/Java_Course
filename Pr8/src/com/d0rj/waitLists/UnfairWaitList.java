package com.d0rj.waitLists;

import java.util.NoSuchElementException;


/**
 * In this waiting list, you can remove an item that is not the first in the queue.
 * @param <E> - type of elements in queue
 */
public class UnfairWaitList<E> extends WaitList<E> {

    public UnfairWaitList() {
        super();
    }


    /**
     * Removes first founded specific element if queue
     * @param element - element to find and remove
     * @throws NoSuchElementException if specific element wasn't founded
     */
    public void remove(E element) throws NoSuchElementException {
        for (var elem : content)
            if (elem.equals(element)) {
                content.remove(elem);
                return;
            }

        throw new NoSuchElementException();
    }


    /**
     * Moves first founded specific element to the tail of queue
     * @param element - element to replace
     * @throws NoSuchElementException if specific element wasn't founded
     */
    public void moveToBack(E element) throws NoSuchElementException {
        remove(element);
        content.add(element);
    }
}
