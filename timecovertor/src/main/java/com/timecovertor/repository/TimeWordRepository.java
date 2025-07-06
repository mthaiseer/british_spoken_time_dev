package com.timecovertor.repository;


import java.util.Map;


/**
 * -----------------------------------------------------------------------------
 * File        : TimeWordRepository.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * -----------------------------------------------------------------------------
 */

public class TimeWordRepository {

    private static final Map<Integer, String> NUM_TO_WORD = Map.ofEntries(
            Map.entry(0, "o'clock"),
            Map.entry(1, "one"),
            Map.entry(2, "two"),
            Map.entry(3, "three"),
            Map.entry(4, "four"),
            Map.entry(5, "five"),
            Map.entry(6, "six"),
            Map.entry(7, "seven"),
            Map.entry(8, "eight"),
            Map.entry(9, "nine"),
            Map.entry(10, "ten"),
            Map.entry(11, "eleven"),
            Map.entry(12, "twelve"),
            Map.entry(13, "thirteen"),
            Map.entry(14, "fourteen"),
            Map.entry(15, "quarter"),
            Map.entry(16, "sixteen"),
            Map.entry(17, "seventeen"),
            Map.entry(18, "eighteen"),
            Map.entry(19, "nineteen"),
            Map.entry(20, "twenty"),
            Map.entry(21, "twenty one"),
            Map.entry(22, "twenty two"),
            Map.entry(23, "twenty three"),
            Map.entry(24, "twenty four"),
            Map.entry(25, "twenty five"),
            Map.entry(26, "twenty six"),
            Map.entry(27, "twenty seven"),
            Map.entry(28, "twenty eight"),
            Map.entry(29, "twenty nine"),
            Map.entry(30, "half")
    );

    public String retrieveTimeFromString(int number) {
        return NUM_TO_WORD.getOrDefault(number, String.valueOf(number));
    }
}
