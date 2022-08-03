package com.practice.test;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr={5, 1, -4, 2, 3};
        int maxSubSum=arr[0];
        int maxSubOut=arr[0];
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum=arr[i];
            for (int j = i+1; j < arr.length; j++) {
                maxSubSum=Math.max(sum,maxSubSum);
                sum=sum+arr[j];
            }
            maxSubOut=Math.max(maxSubOut,maxSubSum);
           // maxSubSum=0;
        }
        System.out.println(maxSubOut);

        int currMax = arr[0];
        int globalMax = arr[0];
        int lengtharray = arr.length;
        for (int i = 1; i < lengtharray; i++) {
            if (currMax < 0) {
                currMax = arr[i];
            } else {
                currMax += arr[i];
            }

            if (globalMax < currMax) {
                globalMax = currMax;
            }
        }
        System.out.println("------------");
        System.out.println(globalMax);
    }
}
