package com.d0rj.task1;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ArrayQueueTest {

    @org.junit.jupiter.api.Test
    void enqueue() {

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);

        var queue = new ArrayQueue<Integer>(2);
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Enqueue(4);

        List<Integer> actual = new ArrayList<>();
        while (!queue.IsEmpty())
            actual.add(queue.Dequeue());

        assertEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test
    void element() {

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);

        var queue = new ArrayQueue<Integer>();
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Enqueue(4);

        List<Integer> actual = new ArrayList<>();

        actual.add(queue.Element());
        queue.Dequeue();
        actual.add(queue.Element());

        assertEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test
    void dequeue() {

        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);

        var queue = new ArrayQueue<Integer>();
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Enqueue(4);

        queue.Dequeue();
        queue.Dequeue();

        List<Integer> actual = new ArrayList<>();
        while (!queue.IsEmpty())
            actual.add(queue.Dequeue());

        assertEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test
    void size() {
        var queue = new ArrayQueue<Integer>(2);
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Enqueue(4);

        assertEquals(queue.Size(), 4);
    }


    @org.junit.jupiter.api.Test
    void isEmpty() {
        var queue = new ArrayQueue<Integer>(2);

        assertTrue(queue.IsEmpty());

        queue.Enqueue(1);
        queue.Dequeue();

        assertTrue(queue.IsEmpty());
    }


    @org.junit.jupiter.api.Test
    void clear() {
        var queue = new ArrayQueue<Integer>(2);
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Enqueue(4);

        queue.Clear();

        assertEquals(queue.Size(), 0);
        assertNull(queue.Element());
        assertTrue(queue.IsEmpty());
    }
}