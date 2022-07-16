package com.practice.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintCountOfOccurencesOfSubSequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int sum = 2;
        int len = arr.length;
        System.out.println(printCountOfSubsequences(0, 0, arr, len, sum));
    }

    private static int printCountOfSubsequences(int i, int s, int[] arr, int len, int sum) {
        if (i == len) {
            if (s == sum) {
                return 1;
            }
            return 0;
        }
        s = s + arr[i];
        int a = printCountOfSubsequences(i + 1, s, arr, len, sum);
        s = s - arr[i];
        int b = printCountOfSubsequences(i + 1, s, arr, len, sum);
        return a + b;
    }
}
