package com.epam.pihnastyi.task4.command.impl;

import com.epam.pihnastyi.task4.command.Command;
import com.epam.pihnastyi.task4.service.ProductService;
import com.epam.pihnastyi.task6.creator.ChooseCreator;
import com.epam.pihnastyi.task6.input.InputHelper;

import java.util.Scanner;

public class AddProduct implements Command {
    private ProductService productService;
    private InputHelper inputHelper;

    public AddProduct(ProductService productService, InputHelper inputHelper) {
        this.productService = productService;
        this.inputHelper = inputHelper;
    }

    /**
     * method execute command
     */
    @Override
    public void doCommand() {
        Scanner sc = new Scanner(System.in);
        printMenu();
        productService.addProduct(new ChooseCreator(inputHelper).doCreate(sc.next()));
    }

    private void printMenu() {
        System.out.println("1 - Product (default)");
        System.out.println("2 - Food");
        System.out.println("3 - Drink");
        System.out.println("4 - Pizza");
    }
}
