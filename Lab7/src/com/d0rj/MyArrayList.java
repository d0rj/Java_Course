package com.d0rj;

import java.util.*;


public class MyArrayList<E> implements List<E> {

    private int capacity;
    private int count;
    private Object[] arr;

    private static final int DEFAULT_CAPACITY = 10;


    public MyArrayList() {
        arr = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        count = 0;
    }


    public MyArrayList(int size) {
        arr = new Object[0];
        reserve(size);
    }


    private boolean indexInBounds(int index) {
        return index >= 0 && index < count;
    }


    private void reserve(int newCapacity) {
        var newArr = new Object[newCapacity];
        System.arraycopy(arr, 0, newArr, 0, capacity);

        arr = newArr;
        capacity = newCapacity;
    }


    @Override
    public int size() {
        return count;
    }


    @Override
    public boolean isEmpty() {
        return count > 0;
    }


    @Override
    public boolean contains(Object o) {
        for (var elem : arr)
            if (o.equals(elem))
                return true;

        return false;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private int currentIndex = 0;


            @Override
            public boolean hasNext() {
                return currentIndex + 1 <= count;
            }


            @Override
            public E next() throws IndexOutOfBoundsException {
                return (E)arr[currentIndex++];
            }
        };
    }


    @Override
    public Object[] toArray() {
        var result = new Object[count];
        System.arraycopy(arr, 0, result, 0, count);

        return result;
    }


    @Override
    public <T> T[] toArray(T[] a) {
        return (T[])toArray();
    }


    @Override
    public boolean add(E t) {
        if (capacity <= count)
            reserve(capacity << 1);

        arr[count++] = t;
        return true;
    }


    @Override
    public boolean remove(Object o) {

        for (int i = 0; i < count; ++i) {
            if (arr[i].equals(o)) {
                for (int j = i + 1; j < count; ++j) {
                    arr[j - 1] = arr[j];
                }
                --count;
                return true;
            }
        }

        return false;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        for (var cElem : c)
            if (!contains(cElem))
                return false;
        return true;
    }


    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (var cElem : c)
            add(cElem);
        return true;
    }


    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (var e : c)
            add(index++, e);
        return true;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        for (var e : c)
            if (contains(e))
                remove(e);
        return true;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < count; ++i)
            if (!c.contains(arr[i]))
                remove(arr[i]);
        return true;
    }


    @Override
    public void clear() {
        count = 0;
        capacity = 0;
    }


    @Override
    public E get(int index) {

        if (!indexInBounds(index))
            throw new IndexOutOfBoundsException();

        return (E) arr[index];
    }


    @Override
    public E set(int index, E element) {

        if (!indexInBounds(index))
            throw new IndexOutOfBoundsException();

        var result = arr[index];
        arr[index] = element;

        return (E) result;
    }


    @Override
    public void add(int index, E element) {
        if (capacity < size() + 1)
            reserve(capacity << 1);

        for (int i = count - 1; i >= index; --i)
            arr[i + 1] = arr[i];

        arr[index] = element;
        ++count;
    }


    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        if (!indexInBounds(index))
            throw new IndexOutOfBoundsException();

        var result = arr[index];
        for (int i = index + 1; i < count; ++i) {
            arr[i - 1] = arr[i];
        }
        --count;

        return (E) result;
    }


    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < count; ++i)
            if (arr[i].equals(o))
                return i;
        return -1;
    }


    @Override
    public int lastIndexOf(Object o) {
        for (int i = count - 1; i >= 0; --i)
            if (arr[i].equals(o))
                return i;
        return -1;
    }



    @Override
    public ListIterator<E> listIterator() {
        return new ListIterator<E>();
    }


    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListIterator<>(index);
    }


    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        var result = new Object[count];
        System.arraycopy(arr, 0, result, 0, count);

        return (List<E>)Arrays.asList(result).subList(fromIndex, toIndex);
    }


    private class ListIterator<T> implements java.util.ListIterator<T> {

        private int currentIndex = 0;


        private ListIterator() {
            currentIndex = 0;
        }


        private ListIterator(int currentIndex) {
            this.currentIndex = currentIndex;
        }


        @Override
        public boolean hasNext() {
            return currentIndex + 1 <= count;
        }


        @Override
        public T next() {
            return (T)arr[currentIndex++];
        }


        @Override
        public boolean hasPrevious() {
            return count < currentIndex - 1;
        }


        @Override
        public T previous() {
            return (T)arr[--currentIndex];
        }


        @Override
        public int nextIndex() {
            return currentIndex;
        }


        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }


        @Override
        public void remove() {
            MyArrayList.this.remove(currentIndex);
        }


        @Override
        public void set(T e) {
            MyArrayList.this.set(currentIndex, (E)e);
        }


        @Override
        public void add(T e) {
            MyArrayList.this.add((E)e);
        }
    }
}
