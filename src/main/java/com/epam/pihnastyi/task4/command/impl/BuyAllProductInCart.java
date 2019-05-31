package com.epam.pihnastyi.task4.command.impl;

import com.epam.pihnastyi.task4.command.Command;
import com.epam.pihnastyi.task4.service.CartService;

import java.time.DateTimeException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class created for Buy All Product In Cart
 */
public class BuyAllProductInCart implements Command {
    private CartService cartService;

    public BuyAllProductInCart(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void doCommand() {
        try {
            System.out.println(cartService.showTotalPrice());
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter order date DD/MM/YYYY");
            String date = sc.next();
            cartService.createOrder(date);
        } catch (NoSuchElementException | DateTimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
