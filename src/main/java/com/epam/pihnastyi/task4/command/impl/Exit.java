package com.epam.pihnastyi.task4.command.impl;

import com.epam.pihnastyi.task4.command.Command;
import com.epam.pihnastyi.task4.service.ProductService;

/**
 * Class created for exist program
 */
public class Exit implements Command {
    ProductService productService;

    public Exit(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void doCommand() {
        productService.serializeProduct();
        System.exit(0);
    }
}
