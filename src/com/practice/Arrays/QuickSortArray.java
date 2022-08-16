package com.practice.Arrays;

public class QuickSortArray {
    public static void main(String[] args) {
        int[] arr={55, 23, 57, 56, 25};
        quickSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void quickSort(int[] arr) {
        quickSortRec(arr,0,arr.length-1);
    }

    private static void quickSortRec(int[] arr, int low , int high) {
        if(low<high){
            int pivot=partition(arr,low,high);
            quickSortRec(arr,low,pivot-1);
            quickSortRec(arr,pivot+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while (i<= high && arr[i]<=pivot)
                i++;
            while(arr[j]>pivot)
                j--;
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        arr[low]=arr[j];
        arr[j]=pivot;
        return j;
    }
}
