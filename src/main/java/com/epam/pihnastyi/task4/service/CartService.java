package com.epam.pihnastyi.task4.service;


import com.epam.pihnastyi.task4.entity.Product;

import java.util.Map;

/**
 * Class created for operated card
 */
public interface CartService {

    /**
     * @param element element for adding
     * @param amount  how many elements to add
     */
    void addElementIntoCart(Product element, int amount);

    /**
     * @param element product for add
     * @param amount  how many product need to add
     *                Method add and save last 5 element added to cart
     */
    void addIntoFiveElementContainer(Product element, int amount);

    /**
     * @return list of product in cart
     * Method show all products into cart
     */
    Map<Product, Integer> showAllElementInCart();

    /**
     * @return last five elements in cart
     * Method show history about last five elements in cart
     */
    Map<Product, Integer> showLastFiveElementAddedInCart();

    /**
     * show total cart price
     */
    double showTotalPrice();

    /**
     * @param date data creating order
     *             Method created new order
     */
    void createOrder(String date);
}
