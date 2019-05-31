package com.epam.pihnastyi.task6.creator.impl;

import com.epam.pihnastyi.task4.entity.Pizza;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task6.creator.ItemCreator;
import com.epam.pihnastyi.task6.input.InputHelper;

public class PizzaCreator implements ItemCreator {

    @Override
    public Product create(InputHelper helper) {
        Pizza pizza = new Pizza();
        fillPizza(pizza, helper);
        return pizza;
    }
}
