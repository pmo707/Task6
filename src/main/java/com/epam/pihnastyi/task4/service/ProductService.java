package com.epam.pihnastyi.task4.service;

import com.epam.pihnastyi.task4.entity.Product;

import java.util.List;

/**
 * Class created for operated products
 */
public interface ProductService {

    /**
     * @return list all product in shop
     */
    List<Product> showAllProduct();

    /**
     * @param productId id of product
     * @return all information about product
     */
    Product getElementById(int productId);

    /**
     * @param products list of products for adding
     */
    void addAllProducts(List<Product> products);

    /**
     * serialize all list products
     */
    void serializeProduct();

    /**
     * deserialize all list products
     */
    void deserializeProduct();

    /**
     * @param product new product for add in shop
     */
    void addProduct(Product product);

}
