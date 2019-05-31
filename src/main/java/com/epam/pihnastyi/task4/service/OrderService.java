package com.epam.pihnastyi.task4.service;

import com.epam.pihnastyi.task4.entity.Product;

import java.time.LocalDate;
import java.util.Map;

/**
 * Class created for operated with orders
 */
public interface OrderService {
    void createOrder(LocalDate date, Map<Product, Integer> cart);

    /**
     * @param startDate  start date for searching
     * @param finishDate finish date for searching
     * @return list of date from start to finish orders
     */
    Map<LocalDate, Map<Product, Integer>> showOrdersByRange(String startDate, String finishDate);

    /**
     * @param date date for searching nearest date
     * @return order near the input date
     */
    Map<LocalDate, Map<Product, Integer>> showNearestDate(String date);
}
