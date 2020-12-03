package com.d0rj.cafe.order;

import com.d0rj.cafe.menu.MenuItem;
import com.d0rj.cafe.interfaces.Order;
import com.d0rj.cafe.utils.LinkedListNode;


public class InternetOrder implements Order {

    private Customer customer;
    private int size = 0;
    private LinkedListNode<MenuItem> head = null;
    private LinkedListNode<MenuItem> tail = null;


    public InternetOrder() {

    }


    public InternetOrder(Customer customer) {
        this.customer = customer;
    }


    @Override
    public boolean add(MenuItem item) {
        if (head == null)
            head = new LinkedListNode<>(item);
        else if (tail == null) {
            tail = new LinkedListNode<>(item);
            head.setNext(tail);
            tail.setPrev(head);
        }
        else {
            var newTail = new LinkedListNode<>(item);
            tail.setNext(newTail);
            newTail.setPrev(tail);
            tail = newTail;
        }

        ++size;
        return true;
    }


    @Override
    public String[] itemsNames() {
        var result = new String[size];

        LinkedListNode<MenuItem> current;
        int i;
        for (i = 0, current = head; current != null; current = current.getNext(), ++i)
            result[i] = current.getData().getName();

        return result;
    }


    @Override
    public int itemsQuantity() {
        return size;
    }


    @Override
    public int itemQuantity(String itemName) {
        var result = 0;

        LinkedListNode<MenuItem> current;
        for (current = head; current != null; current = current.getNext()) {
            if (current.getData().getName().equals(itemName))
                ++result;
        }

        return result;
    }


    @Override
    public int itemQuantity(MenuItem item) {
        var result = 0;

        LinkedListNode<MenuItem> current;
        for (current = head; current != null; current = current.getNext()) {
            if (current.getData().equals(item))
                ++result;
        }

        return result;
    }


    @Override
    public MenuItem[] getItems() {
        var result = new MenuItem[size];

        LinkedListNode<MenuItem> current;
        int i;
        for (i = 0, current = head; current != null; current = current.getNext(), ++i)
            result[i] = current.getData();

        return result;
    }


    @Override
    public boolean remove(String itemName) {
        LinkedListNode<MenuItem> current;
        for (current = head; current != null; current = current.getNext()) {
            if (current.getData().getName().equals(itemName)) {

                if (current.getPrev() == null) {
                    head = current.getNext();
                    head.setPrev(null);
                }
                else if (current.getNext() == null) {
                    tail = current.getPrev();
                    tail.setNext(null);
                }
                else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }

                --size;
                return true;
            }
        }

        return false;
    }


    @Override
    public boolean remove(MenuItem item) {
        LinkedListNode<MenuItem> current;
        for (current = head; current != null; current = current.getNext()) {
            if (current.getData().equals(item)) {

                if (current.getPrev() == null) {
                    head = current.getNext();
                    head.setPrev(null);
                }
                else if (current.getNext() == null) {
                    tail = current.getPrev();
                    tail.setNext(null);
                }
                else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }

                --size;
                return true;
            }
        }

        return false;
    }


    @Override
    public int removeAll(String itemName) {
        var result = 0;
        while (remove(itemName))
            ++result;

        return result;
    }


    @Override
    public int removeAll(MenuItem item) {
        var result = 0;
        while (remove(item))
            ++result;

        return result;
    }


    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        return new MenuItem[0];
    }


    @Override
    public int costTotal() {
        var result = 0;

        LinkedListNode<MenuItem> current;
        for (current = head; current != null; current = current.getNext())
            result += current.getData().getCost();

        return result;
    }


    @Override
    public Customer getCustomer() {
        return customer;
    }


    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
