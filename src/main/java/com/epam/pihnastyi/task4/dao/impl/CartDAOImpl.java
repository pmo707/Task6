package com.epam.pihnastyi.task4.dao.impl;

import com.epam.pihnastyi.task4.dao.CartDAO;
import com.epam.pihnastyi.task4.entity.Product;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;


public class CartDAOImpl implements CartDAO {
    private Map<Product, Integer> basket = new Hashtable<>();
    private Map<Product, Integer> lastFiveElementInCart =
            new LinkedHashMap<Product, Integer>(5, 1f, true) {

                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > 5;
                }
            };

    @Override
    public void add(Product product, int amount) {
        basket.put(product, amount);
    }

    @Override
    public void addInLastElementContainer(Product product, int amount) {
        lastFiveElementInCart.put(product, amount);
    }

    @Override
    public void clearBasket() {
        basket.clear();
    }

    @Override
    public Map<Product, Integer> getAllElementsFromCart() {
        return basket;
    }

    @Override
    public Map<Product, Integer> getFiveLastElements() {
        return lastFiveElementInCart;
    }

    public boolean contains(Product product) {
        return basket.containsKey(product);
    }

    @Override
    public int getCountOfProducts(Product element) {
        if (contains(element)) {
            return basket.get(element);
        }
        return 0;
    }
}
