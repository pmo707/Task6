package com.epam.pihnastyi.task6.input.impl;


import com.epam.pihnastyi.task6.input.InputHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleInputHelper implements InputHelper {

    @Override
    public int getInteger(String message) {
        System.out.println(message);
        String result;
        try {
            while (true) {
                result = scanner.next();
                return Integer.valueOf(result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Try again!");
            return getInteger(message);
        }
    }

    @Override
    public String getString(String message) {
        System.out.println(message);
        return scanner.next();
    }

    @Override
    public boolean getBoolean(String message) {
        System.out.println(message + " true/false");
        String input;

        Pattern p = Pattern.compile("true|false");
        Matcher m;
        while (true) {
            input = scanner.next();
            m = p.matcher(input);
            if (m.find()) {
                break;
            } else {
                System.out.println("Try again!");
                return getBoolean(message);
            }
        }
        return Boolean.valueOf(input);
    }
}
