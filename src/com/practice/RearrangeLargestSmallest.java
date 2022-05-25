package com.practice;

import java.util.Arrays;

/**
 * Given an array of integers, task is to print the array in the order – smallest number, Largest number, 2nd smallest number, 2nd largest number, 3rd smallest number, 3rd largest number and so on…..
 */
public class RearrangeLargestSmallest {
    public static void main(String[] args) {
        int arr[] = {5, 8, 1, 4, 2, 9, 3, 7, 6};
        int newArr[]=new int[arr.length];
        Arrays.sort(arr);
        boolean flag=true;
        int maxN= arr.length-1;
        int minN=0;
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if(flag){
                newArr[i]=arr[minN];
                minN++;
            }else{
                newArr[i]=arr[maxN];
                maxN--;
            }
            flag=!flag;
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]+" ");
        }
    }
}
