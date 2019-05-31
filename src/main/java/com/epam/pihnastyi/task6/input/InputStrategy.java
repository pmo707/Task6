package com.epam.pihnastyi.task6.input;


import com.epam.pihnastyi.task6.input.impl.ConsoleInputHelper;
import com.epam.pihnastyi.task6.input.impl.RandomInputHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Selection of water data option
 */
public class InputStrategy {

    private Scanner scanner = new Scanner(System.in);
    private Map<String, InputHelper> inputTypes = new HashMap<>();

    public InputStrategy() {
    }

    /**
     * @return type of input data
     */
    public InputHelper setInputStrategy() {
        System.out.println("Choice input type" + System.lineSeparator()
                + "0 - MANUAL   1 - RANDOM  ");
        inputTypes.put("0", new ConsoleInputHelper());
        inputTypes.put("1", new RandomInputHelper());

        String type = scanner.nextLine();
        if (inputTypes.containsKey(type)) {
            return inputTypes.get(type);
        } else {
            return setInputStrategy();
        }
    }
}
