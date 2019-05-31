package com.epam.pihnastyi.task4.service.impl;


import com.epam.pihnastyi.task4.dao.CartDAO;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task4.service.CartService;
import com.epam.pihnastyi.task4.service.OrderService;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.epam.pihnastyi.task4.util.Util.getLocalDateFromString;
import static com.epam.pihnastyi.task4.util.Util.isValidDate;

public class CartServiceImpl implements CartService {
    private CartDAO cartDAO;
    private OrderService orderService;

    public CartServiceImpl(CartDAO cartDAO, OrderService orderService) {
        this.cartDAO = cartDAO;
        this.orderService = orderService;
    }

    @Override
    public void addElementIntoCart(Product element, int amount) {
        if (element == null) {
            throw new NoSuchElementException();
        }
        if (cartDAO.contains(element)) {
            int previousCount = cartDAO.getCountOfProducts(element);
            cartDAO.add(element, previousCount + amount);
        } else {
            cartDAO.add(element, amount);
        }
    }

    @Override
    public void addIntoFiveElementContainer(Product element, int amount) {
        if (element == null) {
            return;
        }
        cartDAO.addInLastElementContainer(element, amount);

    }

    @Override
    public Map<Product, Integer> showAllElementInCart() {
        Map<Product, Integer> basket = cartDAO.getAllElementsFromCart();
        if (basket.isEmpty()) {
            throw new NoSuchElementException();
        }
        return basket;
    }

    @Override
    public Map<Product, Integer> showLastFiveElementAddedInCart() {
        return cartDAO.getFiveLastElements();
    }

    @Override
    public double showTotalPrice() {
        Map<Product, Integer> basket = cartDAO.getAllElementsFromCart();
        double totalPrice = 0;
        cartDAO.getAllElementsFromCart();
        for (Map.Entry<Product, Integer> element : basket.entrySet()) {
            totalPrice = totalPrice + element.getKey().getPrice() * element.getValue();
        }
        if (totalPrice == 0) {
            throw new NoSuchElementException("no more elements");
        } else {
            return totalPrice;
        }
    }

    @Override
    public void createOrder(String dateOrder) {
        if (!cartDAO.getAllElementsFromCart().isEmpty()) {
            if (isValidDate(dateOrder)) {
                LocalDate localDateOrder = getLocalDateFromString(dateOrder);
                Map<Product, Integer> cart = new HashMap<>(cartDAO.getAllElementsFromCart());
                orderService.createOrder(localDateOrder, cart);
                cleanCart();
            } else {
                throw new DateTimeException("wrong date");
            }
        }
    }

    private void cleanCart() {
        cartDAO.clearBasket();
    }
}

