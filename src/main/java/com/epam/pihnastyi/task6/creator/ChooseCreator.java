package com.epam.pihnastyi.task6.creator;

import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task6.creator.impl.DrinkCreator;
import com.epam.pihnastyi.task6.creator.impl.FoodCreator;
import com.epam.pihnastyi.task6.creator.impl.PizzaCreator;
import com.epam.pihnastyi.task6.creator.impl.ProductCreator;
import com.epam.pihnastyi.task6.input.InputHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Class create selected type of product
 */
public class ChooseCreator {

    private InputHelper inputHelper;

    public ChooseCreator(InputHelper inputHelper) {
        this.inputHelper = inputHelper;
    }

    /**
     * @param key product type
     * @return created product by Type
     */
    public Product doCreate(String key) {
        Map<String, ItemCreator> creatorMap = new HashMap<>();
        creatorMap.put("1", new ProductCreator());
        creatorMap.put("2", new FoodCreator());
        creatorMap.put("3", new DrinkCreator());
        creatorMap.put("4", new PizzaCreator());
        if (creatorMap.containsKey(key)) {
            return creatorMap.get(key).create(inputHelper);
        } else return creatorMap.get("1").create(inputHelper);
    }

}
