package com.practice.Arrays;

public class SubArrayWithWindow {
    public static void main(String[] args) {
        int[] arr={2, 1, 5, 1, 3, };
        int k=3;
       int max= findMaxSum(arr,k);
        System.out.println(max);
    }

    private static int findMaxSum(int[] arr, int k) {
        int windowStart=0,windowEnd=0,windowSum=0;
        int max=0;
        for (windowEnd=0;windowEnd< arr.length;windowEnd++){
            windowSum=windowSum+arr[windowEnd];
            if(windowEnd>=k-1){
                max=Math.max(max,windowSum);
                windowSum=windowSum-arr[windowStart];
                windowStart++;
            }
        }
        return max;
    }
}
