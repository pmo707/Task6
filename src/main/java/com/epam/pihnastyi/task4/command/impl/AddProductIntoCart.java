package com.epam.pihnastyi.task4.command.impl;


import com.epam.pihnastyi.task4.command.Command;
import com.epam.pihnastyi.task4.service.CartService;
import com.epam.pihnastyi.task4.service.ProductService;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class created for Add Product Into Cart
 */
public class AddProductIntoCart implements Command {

    private CartService cartService;
    private ProductService productService;

    public AddProductIntoCart(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @Override
    public void doCommand() {
        Scanner sc = new Scanner(System.in);
        int countOfProducts = 0;
        int productId = 0;
        try {
            System.out.println("Please enter product id");
            productId = sc.nextInt();
            System.out.println("Please enter product amount");
            countOfProducts = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong type input type. try to use numbers");
        }
        if (countOfProducts > 0) {
            try {
                cartService.addElementIntoCart(productService.getElementById(productId), countOfProducts);
                cartService.addIntoFiveElementContainer(productService.getElementById(productId), countOfProducts);
            } catch (NoSuchElementException e) {
                System.out.println("Element has not found in productShop");
            }
        }
    }
}
