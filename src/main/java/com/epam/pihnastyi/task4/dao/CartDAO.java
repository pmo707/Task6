package com.epam.pihnastyi.task4.dao;


import com.epam.pihnastyi.task4.entity.Product;

import java.util.Map;

/**
 * Class created for storage card and do get data form storage
 */
public interface CartDAO {

    /**
     * @param product product for add
     * @param amount  how many product need to add
     *                Method add element in cart
     */
    void add(Product product, int amount);

    /**
     * @param product product for add
     * @param amount  how many product need to add
     *                Method add and save last 5 element added to cart
     */
    void addInLastElementContainer(Product product, int amount);

    /**
     * Method clean cart
     */
    void clearBasket();

    /**
     * @return all element from cart
     * Method find all elements in cart
     */
    Map<Product, Integer> getAllElementsFromCart();

    /**
     * @return last five element from cart added
     * Method last five element from cart added
     */
    Map<Product, Integer> getFiveLastElements();

    boolean contains(Product product);

    int getCountOfProducts(Product element);
}
