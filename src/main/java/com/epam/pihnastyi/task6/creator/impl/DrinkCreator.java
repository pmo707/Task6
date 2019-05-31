package com.epam.pihnastyi.task6.creator.impl;

import com.epam.pihnastyi.task4.entity.Drink;
import com.epam.pihnastyi.task6.creator.ItemCreator;
import com.epam.pihnastyi.task6.input.InputHelper;


public class DrinkCreator implements ItemCreator {

    @Override
    public Drink create(InputHelper helper) {
        Drink drink = new Drink();
        fill(drink, helper);
        drink.setSugar(helper.getBoolean("set sugar"));
        drink.setGas(helper.getBoolean("set gas"));
        drink.setPackagingType(helper.getString("set packaging type"));
        return drink;
    }
}
