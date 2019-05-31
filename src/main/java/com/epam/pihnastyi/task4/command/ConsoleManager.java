package com.epam.pihnastyi.task4.command;

import com.epam.pihnastyi.task4.command.impl.*;
import com.epam.pihnastyi.task4.dao.CartDAO;
import com.epam.pihnastyi.task4.dao.OrderDAO;
import com.epam.pihnastyi.task4.dao.ProductDAO;
import com.epam.pihnastyi.task4.dao.impl.CartDAOImpl;
import com.epam.pihnastyi.task4.dao.impl.OrderDAOImpl;
import com.epam.pihnastyi.task4.dao.impl.ProductDAOImpl;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task4.filler.FillingConsoleShop;
import com.epam.pihnastyi.task4.service.CartService;
import com.epam.pihnastyi.task4.service.OrderService;
import com.epam.pihnastyi.task4.service.ProductService;
import com.epam.pihnastyi.task4.service.impl.CartServiceImpl;
import com.epam.pihnastyi.task4.service.impl.OrderServiceImpl;
import com.epam.pihnastyi.task4.service.impl.ProductServiceImpl;
import com.epam.pihnastyi.task6.input.InputHelper;
import com.epam.pihnastyi.task6.input.InputStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Class created for working with client
 */
public class ConsoleManager {
    private Map<String, Command> mapCommand = new HashMap<>();
    private List<Product> product = new FillingConsoleShop().setArrayListByTestData();
    private ProductDAO productDAO = new ProductDAOImpl();
    private CartDAO cartDAO = new CartDAOImpl();
    private OrderDAO orderDAO = new OrderDAOImpl();
    private ProductService productService = new ProductServiceImpl(productDAO);
    private OrderService orderService = new OrderServiceImpl(orderDAO);
    private CartService cartService = new CartServiceImpl(cartDAO, orderService);
    private InputHelper inputHelper = new InputStrategy().setInputStrategy();

    public ConsoleManager() {
        mapCommand.put("1", new ShowAllProductInShop(productService));
        mapCommand.put("2", new AddProductIntoCart(cartService, productService));
        mapCommand.put("3", new ShowAllProductInCart(cartService));
        mapCommand.put("4", new BuyAllProductInCart(cartService));
        mapCommand.put("5", new ShowLastFiveAddedProduct(cartService));
        mapCommand.put("6", new SearchByRangeDate(orderService));
        mapCommand.put("7", new SearchByNearestDate(orderService));
        mapCommand.put("8", new AddProduct(productService, inputHelper));
        mapCommand.put("0", new Exit(productService));
    }

    /**
     * Method load console interface.
     */
    public void command() {
        CommandController commandClient = new CommandController();
        productService.deserializeProduct();
        if (productService.showAllProduct().size() == 0) productService.addAllProducts(product);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Please enter the command\n" +
                    ("---------------------------"));
            System.out.println("CONSOLE SHOP \n" +
                    "1.store\n" +
                    "2.add to cart\n" +
                    "3.cart\n" +
                    "4.buy all product from cart\n" +
                    "5.show last 5 element added in cart\n" +
                    "6.search by range date\n" +
                    "7.search by nearest date\n" +
                    "8.add product\n" +
                    "0.exit");
            String number = sc.nextLine();
            if (mapCommand.containsKey(number)) {
                commandClient.setCommand(mapCommand.get(number));
                commandClient.executeCommand();
            } else System.out.println("wrong command");
        }
    }
}
