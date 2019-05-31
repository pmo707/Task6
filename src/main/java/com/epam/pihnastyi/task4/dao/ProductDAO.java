package com.epam.pihnastyi.task4.dao;


import com.epam.pihnastyi.task4.entity.Product;

import java.util.List;

/**
 * Class created for storage order and do get data form storage
 */
public interface ProductDAO {

    /**
     * @param elementId id element for finding
     * @return return Product by id
     */
    Product getElementById(int elementId);

    /**
     * @return all products in the shop
     */
    List<Product> getAllProducts();

    /**
     * @param products list of products for adding
     */
    void addAllProducts(List<Product> products);

    void addProduct(Product product);
}
