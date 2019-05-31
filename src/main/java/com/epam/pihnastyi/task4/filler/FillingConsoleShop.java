package com.epam.pihnastyi.task4.filler;

import com.epam.pihnastyi.task4.entity.Product;

import java.util.ArrayList;

/**
 * Class created for filling the store with product
 */
public class FillingConsoleShop {

    /**
     * @return list with products
     */
    public ArrayList<Product> setArrayListByTestData() {
        ArrayList<Product> productsShop = new ArrayList<>();
        productsShop.add(new Product(1, "1", "1", 1));
        productsShop.add(new Product(2, "2", "2", 2));
        productsShop.add(new Product(3, "3", "3", 3));
        productsShop.add(new Product(4, "4", "4", 4));
        productsShop.add(new Product(5, "5", "5", 5));
        productsShop.add(new Product(6, "6", "6", 6));
        productsShop.add(new Product(7, "7", "7", 7));
        productsShop.add(new Product(8, "8", "8", 8));
        return productsShop;
    }
}
