package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://www.geeksforgeeks.org/sort-elements-by-frequency/
 * Sort elements by frequency
 * Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
 * Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
 * <p>
 * Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
 * Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
 */
public class SortByFrequency {
    public static void main(String[] args) {
        int arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
        final HashMap<Integer, Integer> mapCount
                = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (mapCount.containsKey(arr[i])) {
                int count = mapCount.get(arr[i]);
                count++;
                mapCount.put(arr[i], count);
            } else {
                mapCount.put(arr[i], 1);
            }
        }
        HashMap<Integer, Integer> temp
                = mapCount.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i2.getValue().compareTo(
                        i1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        int i = 0;
        for (Map.Entry<Integer, Integer> map : temp.entrySet()) {
            int run = map.getValue();
            for (int j = 0; j < run; j++) {
                arr[i] = map.getKey();
                i++;
            }

            if (i > arr.length) {
                break;
            }
        }

        for (int f = 0; f < arr.length; f++) {
            System.out.print(arr[f]+",");

        }
    }
}
