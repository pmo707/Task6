package com.epam.pihnastyi.task4.dao.impl;


import com.epam.pihnastyi.task4.dao.ProductDAO;
import com.epam.pihnastyi.task4.entity.Product;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductDAOImpl implements ProductDAO {
    private List<Product> productsShop;

    @Override
    public Product getElementById(int elementId) {
        for (Product product : productsShop) {
            if (product.getId() == elementId) {
                return product;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public List<Product> getAllProducts() {
        return productsShop;
    }

    @Override
    public void addAllProducts(List<Product> products) {
        productsShop = products;
    }

    @Override
    public void addProduct(Product product) {
        product.setId(productsShop.size() + 1);
        productsShop.add(product);
    }
}
