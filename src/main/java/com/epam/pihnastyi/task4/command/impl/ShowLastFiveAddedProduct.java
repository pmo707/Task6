package com.epam.pihnastyi.task4.command.impl;

import com.epam.pihnastyi.task4.command.Command;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task4.service.CartService;

import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Class created for show last 5 added product in cart
 */
public class ShowLastFiveAddedProduct implements Command {

    private CartService cartService;

    public ShowLastFiveAddedProduct(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void doCommand() {
        try {
            Map<Product, Integer> basket = cartService.showLastFiveElementAddedInCart();
            for (Product product : basket.keySet()) {
                System.out.println(product);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Cart is empty");
        }
    }
}
