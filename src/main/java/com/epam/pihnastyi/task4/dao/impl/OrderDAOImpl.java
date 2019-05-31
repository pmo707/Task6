package com.epam.pihnastyi.task4.dao.impl;


import com.epam.pihnastyi.task4.dao.OrderDAO;
import com.epam.pihnastyi.task4.entity.Product;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class OrderDAOImpl implements OrderDAO {
    private TreeMap<LocalDate, Map<Product, Integer>> orders = new TreeMap<>();

    @Override
    public void add(LocalDate date, Map<Product, Integer> map) {
        orders.put(date, map);
    }

    public TreeMap<LocalDate, Map<Product, Integer>> getAllOrders() {
        return orders;
    }
}
