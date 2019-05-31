package com.epam.pihnastyi.task6.creator.impl;

import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task6.creator.ItemCreator;
import com.epam.pihnastyi.task6.input.InputHelper;

public class ProductCreator implements ItemCreator {

    @Override
    public Product create(InputHelper helper) {
        Product product = new Product();
        fill(product, helper);
        return product;
    }
}
