package com.practice.Arrays;

public class IndexedSort {
    public static void main(String[] args) {
        int[] arr={2,1,4,3,5};
        indexedSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    private static void indexedSort(int[] nums) {
        int i=0;
        while(i<nums.length){
            int j=i+1;
            if(nums[i]!=j){
                swap(nums,i,j);
            }
            i++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
