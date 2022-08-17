package com.practice.Arrays;

public class SmallestSubArraySumWindow {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int sum = 7;
        int minLength2 = findSmallesSubarray(arr, sum);
        System.out.println(minLength2);
        System.out.println(findMinSubArray(sum,arr));
    }

    private static int findSmallesSubarray(int[] arr, int sum) {
        int windowSum  = 0,minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while (windowSum >= sum) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
