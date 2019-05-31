package com.epam.pihnastyi.task6.creator;

import com.epam.pihnastyi.task4.entity.Food;
import com.epam.pihnastyi.task4.entity.Pizza;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task6.input.InputHelper;

/**
 * Create filling selected product
 */
public interface ItemCreator {

    /**
     * @param helper input type of product
     * @return filled product
     */
    Product create(InputHelper helper);

    /**
     * @param product     Type for filling
     * @param inputHelper type of input
     */
    default void fill(Product product, InputHelper inputHelper) {
        product.setName(inputHelper.getString("Name"));
        product.setColor(inputHelper.getString("Color"));
        product.setPrice(inputHelper.getInteger("Price"));
    }

    /**
     * @param product     Type for filling
     * @param inputHelper type of input
     */
    default void fillFood(Food product, InputHelper inputHelper) {
        fill(product, inputHelper);
        product.setHealthy(inputHelper.getBoolean("Is healthy"));
        product.setCountry(inputHelper.getString("Country"));
    }

    /**
     * @param product     Type for filling
     * @param inputHelper type of input
     */
    default void fillPizza(Pizza product, InputHelper inputHelper) {
        fillFood(product, inputHelper);
        product.setWeight(inputHelper.getInteger("Weight"));
        product.setSize(inputHelper.getInteger("Size"));
    }
}
