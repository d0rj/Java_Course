package com.d0rj;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.util.*;


public final class MyArrayList<E> implements List<E> {

    private int capacity;
    private int count;
    private E[] arr;
    private Class<E> typeOfT;


    public MyArrayList() {
        this.typeOfT = (Class<E>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }


    public MyArrayList(int size) {
        this.typeOfT = (Class<E>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
        reserve(size);
    }


    private E[] createNewArray(int size) {
        return (E[]) Array.newInstance(typeOfT, size);
    }


    private boolean indexInBounds(int index) {
        return index < 0 || index >= capacity;
    }


    private void reserve(int newCapacity) {
        var newArr = createNewArray(newCapacity);
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
        return null;
    }


    @Override
    public Object[] toArray() {
        var result = new Object[count];
        System.arraycopy(arr, 0, result, 0, count);

        return result;
    }


    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
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
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
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

        return arr[index];
    }


    @Override
    public E set(int index, E element) {

        if (!indexInBounds(index))
            throw new IndexOutOfBoundsException();

        var result = arr[index];
        arr[index] = element;

        return result;
    }


    @Override
    public void add(int index, E element) {

    }


    @Override
    public E remove(int index) {
        if (!indexInBounds(index))
            throw new IndexOutOfBoundsException();

        var result = arr[index];
        for (int i = index + 1; i < count; ++i) {
            arr[i - 1] = arr[i];
        }
        --count;

        return result;
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
        return null;
    }


    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }


    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        var slice = createNewArray(toIndex - fromIndex);

        for (int i = 0; i < slice.length; ++i)
            slice[i] = arr[fromIndex + i];

        return Arrays.asList(slice);
    }
}
