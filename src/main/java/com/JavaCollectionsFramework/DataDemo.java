package com.JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.List;

public class DataDemo {
    public static List<Integer> getAllNumbers(Data data) {
        List<Integer> allNumbers = new ArrayList<>();
        for (int number : data) {
            allNumbers.add(number);
        }
        return allNumbers;
    }
}
