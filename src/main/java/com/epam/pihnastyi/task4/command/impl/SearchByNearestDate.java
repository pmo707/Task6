package com.epam.pihnastyi.task4.command.impl;

import com.epam.pihnastyi.task4.command.Command;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task4.service.OrderService;

import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class created for Searching orders By Nearest Date
 */
public class SearchByNearestDate implements Command {
    private OrderService orderService;

    public SearchByNearestDate(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void doCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter order date DD/MM/YYYY");
        String date = sc.next();
        try {
            Map<LocalDate, Map<Product, Integer>> nearestDate = orderService.showNearestDate(date);
            System.out.println(nearestDate.entrySet());
        } catch (NoSuchElementException e) {
            System.out.println("No one has ordered before");
        }
    }
}
