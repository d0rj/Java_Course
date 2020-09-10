package com.d0rj.cafe.order;

import com.d0rj.cafe.menu.MenuItem;
import com.d0rj.cafe.interfaces.Order;
import com.d0rj.cafe.interfaces.OrdersManager;


public class InternetOrdersManager implements OrdersManager {

    private QueueNode head;
    private QueueNode tail;
    private int size;


    boolean add(Order order) {
        return false;
    }

    @Override
    public int itemsQuantity(String itemName) {
        return 0;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        return 0;
    }

    @Override
    public Order[] getOrders() {
        return new Order[0];
    }

    @Override
    public int ordersCostSummary() {
        return 0;
    }

    @Override
    public int ordersQuantity() {
        return 0;
    }
}
