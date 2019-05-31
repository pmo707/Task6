package com.epam.pihnastyi.task6.creator.impl;

import com.epam.pihnastyi.task4.entity.Food;
import com.epam.pihnastyi.task6.creator.ItemCreator;
import com.epam.pihnastyi.task6.input.InputHelper;


public class FoodCreator implements ItemCreator {

    @Override
    public Food create(InputHelper helper) {
        Food food = new Food();
        fillFood(food, helper);
        return food;
    }
}
