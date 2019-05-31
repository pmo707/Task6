package com.epam.pihnastyi.task4.service.impl;

import com.epam.pihnastyi.task4.dao.OrderDAO;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task4.service.OrderService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import static com.epam.pihnastyi.task4.util.Util.getLocalDateFromString;
import static com.epam.pihnastyi.task4.util.Util.isValidDate;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void createOrder(LocalDate date, Map<Product, Integer> cart) {
        orderDAO.add(date, cart);
    }

    @Override
    public Map<LocalDate, Map<Product, Integer>> showOrdersByRange(String dateStart, String dateFinish) {
        return findByRangeDate(dateStart, dateFinish);
    }

    @Override
    public Map<LocalDate, Map<Product, Integer>> showNearestDate(String date) {
        return findNearestDate(date);
    }

    private Map<LocalDate, Map<Product, Integer>> findByRangeDate(String dateStart, String dateFinish) {
        Map<LocalDate, Map<Product, Integer>> filteredOrder;
        if (isValidDate(dateStart) && isValidDate(dateFinish)) {
            LocalDate localDateStart = getLocalDateFromString(dateStart);
            LocalDate localDateFinish = getLocalDateFromString(dateFinish);
            TreeMap<LocalDate, Map<Product, Integer>> orders = orderDAO.getAllOrders();
            filteredOrder = orders.subMap(localDateStart, true, localDateFinish, true);
            return filteredOrder;
        }
        throw new NoSuchElementException();
    }

    private Map<LocalDate, Map<Product, Integer>> findNearestDate(String date) {
        Map<LocalDate, Map<Product, Integer>> nearestOrder = new HashMap<>();
        if (isValidDate(date)) {
            TreeMap<LocalDate, Map<Product, Integer>> orders = orderDAO.getAllOrders();
            LocalDate localDate = getLocalDateFromString(date);
            LocalDate beforeNearestDate = orders.floorKey(localDate);
            LocalDate afterNearestDate = orders.ceilingKey(localDate);
            if (afterNearestDate != null && beforeNearestDate != null) {
                if (afterNearestDate.compareTo(localDate) > beforeNearestDate.compareTo(localDate)) {
                    nearestOrder.put(afterNearestDate, orders.get(afterNearestDate));
                } else {
                    nearestOrder.put(beforeNearestDate, orders.get(beforeNearestDate));
                }
            }
            if (beforeNearestDate == null && afterNearestDate != null) {
                nearestOrder.put(afterNearestDate, orders.get(afterNearestDate));
            }
            if (afterNearestDate == null && beforeNearestDate != null) {
                nearestOrder.put(beforeNearestDate, orders.get(beforeNearestDate));
            }
            throw new NoSuchElementException();
        }
        return nearestOrder;
    }
}
