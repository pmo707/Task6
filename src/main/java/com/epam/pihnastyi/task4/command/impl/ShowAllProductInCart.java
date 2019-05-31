package com.epam.pihnastyi.task4.command.impl;

import com.epam.pihnastyi.task4.command.Command;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task4.service.CartService;

import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Class created for show all products in cart
 */
public class ShowAllProductInCart implements Command {

    private CartService cartService;

    public ShowAllProductInCart(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void doCommand() {
        try {
            Map<Product, Integer> basket = cartService.showAllElementInCart();
            for (Map.Entry e : basket.entrySet()) {
                System.out.println(e);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Cart is empty");
        }
    }
}
