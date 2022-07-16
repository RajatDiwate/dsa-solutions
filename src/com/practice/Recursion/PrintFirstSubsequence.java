package com.practice.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintFirstSubsequence {


    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        List<Integer> newArr = new ArrayList<>();
        int len = 3;
        int sum = 2;
        printFirstSubSequence(0, newArr, 0, arr, len, sum);
    }

    private static boolean printFirstSubSequence(int i, List<Integer> newArr, int s, int[] arr, int len, int sum) {
        if (i == len) {
            if (s == sum) {
                newArr.forEach(System.out::print);
                return true;
            } else
                return false;
        }
        newArr.add(arr[i]);
        s = s + arr[i];
        if (printFirstSubSequence(i + 1, newArr, s, arr, len, sum)) {
            return true;
        }
        newArr.remove(Integer.valueOf(arr[i]));
        s = s - arr[i];
        if (printFirstSubSequence(i + 1, newArr, s, arr, len, sum)) {
            return true;
        }
        return false;
    }

}
