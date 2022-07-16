package com.practice.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequesnceAddition {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int len = 3;
        int sum = 2;
        List<Integer> integerList = new ArrayList<>();
        printSubSeqAddition(0, integerList, 0, arr, len, sum);
    }

    private static void printSubSeqAddition(int i, List<Integer> integerList, int s, int[] arr, int len, int sum) {
        if (i == len) {
            if (sum == s) {
                integerList.forEach(System.out::print);
                System.out.println();
            }
            return;
        }
        integerList.add(arr[i]);
        s += arr[i];
        printSubSeqAddition(i + 1, integerList, s, arr, len, sum);
        integerList.remove(Integer.valueOf(arr[i]));
        s -= arr[i];
        printSubSeqAddition(i + 1, integerList, s, arr, len, sum);

    }
}
