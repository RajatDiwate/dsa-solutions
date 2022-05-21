package com.practice;

/**
 * Largest Sum Contiguous Subarray
 * int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
 * Maximum contiguous sum is 7
 */
public class LargestContiguousSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
      //  arr= new int[]{-2, -3, -4, -1, -2, -1, -5, -3};
        int counter = getCounter(arr);
        System.out.println(counter);
        counter = getCounter2(arr);
        System.out.println(counter);
        counter = getCounterForAllNegativeArray(arr);
        System.out.println(counter);

    }

    private static int getCounter(int[] arr) {
        int counter = arr[0];
        int maxCounter = Math.max(arr[0], 0);
        for (int i = 1; i < arr.length; i++) {
            counter = Math.max(counter, arr[i] + maxCounter);
            maxCounter += arr[i];
            if (maxCounter < 0) maxCounter = 0;
        }
        return counter;
    }

    private static int getCounter2(int[] arr) {
        int counter = arr[0];
        int maxCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            maxCounter = arr[i] + maxCounter;
            if (maxCounter < 0) maxCounter = 0;
            else if (maxCounter > counter) counter = maxCounter;
        }
        return counter;
    }

    private static int getCounterForAllNegativeArray(int[] arr) {
        int counter = arr[0];
        int maxCounter = arr[0];
        for (int i = 1; i < arr.length; i++) {
            counter = Math.max(arr[i], arr[i] + counter);
            maxCounter = Math.max(maxCounter, counter);
        }
        return counter;
    }
}
