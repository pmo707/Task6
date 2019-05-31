package com.epam.pihnastyi.task6.input.impl;


import com.epam.pihnastyi.task4.util.Util;
import com.epam.pihnastyi.task6.input.InputHelper;

public class RandomInputHelper implements InputHelper {

    @Override
    public int getInteger(String message) {
        return random.nextInt(100);
    }

    @Override
    public String getString(String message) {
        return Util.randomWord(3, 10);
    }

    @Override
    public boolean getBoolean(String message) {
        return random.nextBoolean();
    }
}
