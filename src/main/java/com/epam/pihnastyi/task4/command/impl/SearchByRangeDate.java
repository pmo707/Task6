package com.epam.pihnastyi.task4.command.impl;

import com.epam.pihnastyi.task4.command.Command;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task4.service.OrderService;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

/**
 * Class created for Searching orders By Range Date
 */
public class SearchByRangeDate implements Command {

    private OrderService orderService;

    public SearchByRangeDate(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void doCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter order dateStart DD/MM/YYYY");
        String dateStart = sc.next();
        System.out.println("Please enter order dateEnd DD/MM/YYYY");
        String dateFinish = sc.next();
        Map<LocalDate, Map<Product, Integer>> filteredOrder = orderService.showOrdersByRange(dateStart, dateFinish);
        for (Map.Entry e : filteredOrder.entrySet()) {
            System.out.println(e);
        }
    }
}
