package com.epam.pihnastyi.task4.dao;


import com.epam.pihnastyi.task4.entity.Product;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class created for storage order and do get data form storage
 */
public interface OrderDAO {

    /**
     * @param date date in format dd/mm/yyyy
     * @param map  all products in cart
     *             Method created new order
     */
    void add(LocalDate date, Map<Product, Integer> map);

    /**
     * @return all orders in order list
     * Method get all order
     */
    TreeMap<LocalDate, Map<Product, Integer>> getAllOrders();
}
