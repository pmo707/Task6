package com.epam.pihnastyi.task4.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Class created for validate input date
 */
public class Util {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d/MM/yyyy");

    /**
     * @param date input date
     * @return checks if this date is valid
     */
    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date, DATE_FORMAT);
        } catch (DateTimeException e) {
            return false;
        }
        return true;
    }

    /**
     * @param date input sting date
     * @return date by format
     */
    public static LocalDate getLocalDateFromString(String date) {
        return LocalDate.parse(date, DATE_FORMAT);
    }

    /**
     * @param start the beginning of the interval length word
     * @param end   the ending of the interval length word
     * @return random word
     */
    public static String randomWord(int start, int end) {
        int wordLength = start + (int) (Math.random() * end);
        StringBuffer sb = new StringBuffer(wordLength);
        Random r = new Random();

        for (int i = 0; i < wordLength; i++) {
            char tmp = (char) ('a' + r.nextInt('z' - 'a'));
            sb.append(tmp);
        }
        return sb.toString();
    }
}
