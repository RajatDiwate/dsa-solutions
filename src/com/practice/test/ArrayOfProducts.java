package com.practice.test;

import java.util.Arrays;

public class ArrayOfProducts {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int[] arr2 = getInts(arr);
        Arrays.stream(arr2).forEach(x->System.out.print(x+" "));
        findProduct(arr);
    }
    public static int[] findProduct(int arr[])
    {
        int n = arr.length;
        int i, temp = 1;

        // Allocation of result array
        int result[] = new int[n];

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++)
        {
            result[i] = temp;
            temp *= arr[i];
        }

        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i]
        for (i = n - 1; i >= 0; i--)
        {
            result[i] *= temp;
            temp *= arr[i];
        }

        return result;
    }

    private static int[] getInts(int[] arr) {
        int result;
        int[] arr2=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result =1;
            for (int j = 0; j < arr.length; j++) {
                if(i==j){
                }else{
                    result*= arr[j];
                }
            }
            arr2[i]=result;
        }
        return arr2;
    }
}
