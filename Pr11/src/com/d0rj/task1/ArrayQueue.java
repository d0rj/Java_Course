package com.d0rj.task1;


public class ArrayQueue<T> {

    private Object[] array;
    private int size;
    private int capacity;
    private int head;
    private int tail;
    private final int DefaultCapacity = 10;


    public ArrayQueue(int size) throws IllegalArgumentException
    {
        if (size < 1)
            throw new IllegalArgumentException();

        array = new Object[size];
        capacity = size;
        this.size = 0;
        head = -1;
        tail = 0;
    }


    public ArrayQueue()
    {
        array = new Object[DefaultCapacity];
        capacity = DefaultCapacity;
        size = 0;
        head = -1;
        tail = 0;
    }


    public void Enqueue(Object newElement) throws IllegalArgumentException
    {
        if (newElement == null)
            throw new IllegalArgumentException();

        if (size == capacity)
        {
            Object[] newQueue = new Object[2 * capacity];
            System.arraycopy(array, 0, newQueue, 0, array.length);
            array = newQueue;
            capacity *= 2;
        }
        ++size;

        array[tail++ % capacity] = newElement;
    }


    public final T Element()
    {
        if (size == 0)
            return null;

        return (T)array[head + 1 % capacity];
    }


    public T Dequeue()
    {
        if (size == 0)
            return null;

        --size;
        return (T)array[++head % capacity];
    }


    public final int Size() {
        return size;
    }


    public final boolean IsEmpty()
    {
        return size == 0;
    }


    public void Clear()
    {
        while (size != 0)
            Dequeue();
    }
}
