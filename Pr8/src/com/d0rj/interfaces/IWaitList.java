package com.d0rj.interfaces;

import java.util.Collection;


public interface IWaitList<E> {

    /**
     * Add element to wait list
     * @param element - element to add
     */
    void add(E element);

    /**
     * Remove first element in queue
     * @return that element
     */
    E remove();

    /**
     * Check queue contains specific element
     * @param element - element to check
     * @return TRUE if queue contains element, else - FALSE
     */
    boolean contains(E element);

    /**
     * Check queue contains all elements in specific Collection
     * @param c - collection with elements to check
     * @return TRUE if queue contains all elements in Collection c, else - FALSE
     */
    boolean containsAll(Collection<E> c);

    /**
     * Check queue is empty
     * @return TRUE if queue hasn't any objects, else - FALSE
     */
    boolean isEmpty();
}
