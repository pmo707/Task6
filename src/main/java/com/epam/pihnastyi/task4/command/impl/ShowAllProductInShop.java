package com.epam.pihnastyi.task4.command.impl;

import com.epam.pihnastyi.task4.command.Command;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task4.service.ProductService;

/**
 * Class created for show all products in consoleShop
 */
public class ShowAllProductInShop implements Command {

    private ProductService productService;

    public ShowAllProductInShop(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void doCommand() {
        for (Product product : productService.showAllProduct()) {
            System.out.println(product);
        }
    }
}
