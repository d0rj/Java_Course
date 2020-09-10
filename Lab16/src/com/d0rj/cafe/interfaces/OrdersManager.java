package com.d0rj.cafe.interfaces;

import com.d0rj.cafe.menu.MenuItem;


public interface OrdersManager {

    int itemsQuantity(String itemName);
    int itemsQuantity(MenuItem item);
    Order[] getOrders();
    int ordersCostSummary();
    int ordersQuantity();
}
