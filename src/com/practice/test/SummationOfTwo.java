package com.practice.test;

import java.util.Arrays;

public class SummationOfTwo {

    public static void main(String[] args) {
        int[] result = findSum(new int[]{9, 4, 7, 2, 6}, 17);
        Arrays.stream(result).forEach(System.out::print);
    }

    private static int[] findSum(int[] ints, int i) {
        sort(0, ints.length-1, ints);
        return ints;

    }

    private static void sort(int low, int high, int[] ints) {
        if (low < high) {
            int pi = partition(low, high, ints);
            sort(low, pi - 1, ints);
            sort(pi + 1, high, ints);
        }
    }

    private static int partition(int low, int high, int[] ints) {
        int pivot = ints[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (ints[j] <= pivot) {
                i++;
                int temp = ints[i];
                ints[i] = ints[j];
                ints[j] = temp;
            }
        }
        int temp = ints[i + 1];
        ints[i + 1] = ints[high];
        ints[high] = temp;

        return i + 1;

    }

}
