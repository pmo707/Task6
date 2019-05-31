package com.epam.pihnastyi.task6.input;


import java.util.Random;
import java.util.Scanner;

/**
 * Provides data entry of different types
 */
public interface InputHelper {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    /**
     * @param message information about type format
     * @return filled input value
     */
    int getInteger(String message);

    /**
     * @param message information about type format
     * @return filled input value
     */
    String getString(String message);

    /**
     * @param message information about type format
     * @return filled input value
     */
    boolean getBoolean(String message);
}
