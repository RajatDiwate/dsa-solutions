package com.practice.Arrays;

import java.util.stream.IntStream;

public class BinarySearchAgnostic {
    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 8).toArray();
        int index = findIndexOfElement(arr, 5);
        System.out.println(index);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static int findIndexOfElement(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        boolean isAsc = arr[low] < arr[high];
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == value) {
                return mid;
            }
            if (!isAsc) {
                if (arr[mid] < value) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] > value) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }


        }
        return -1;
    }
}
