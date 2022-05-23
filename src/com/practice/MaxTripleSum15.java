package com.practice;

public class MaxTripleSum15 {
    public static void main(String[] args) {
        int arr[] = { 1, 0, 8, 6, 4, 2 };
        int n = arr.length;
       getMax3Sum(arr, n);
    }

    private static int getMax3Sum(int[] arr, int n) {
        int max1=0;
        int max2=0;
        int max3=0;
        for (int i = 0; i < n; i++) {
                int value=arr[i];
                if(value>max1){
                    max3=max2;
                    max2=max1;
                    max1=value;

                }else if(value>max2){
                    max3=max2;
                    max2=value;
                }else{
                    max3=value;
                }
        }
        System.out.println(max1+":max2:"+max2+":max3:"+max3);
        return max1+max2+max3;
    }
}
