package com.practice.Arrays;

public class MoveZeroToLeft {
    public static void main(String[] args) {
        int[] arr = {1, 10, 20, 0, 59, 63, 0, 88, 0};
        int reader=arr.length-1;
        int writer= arr.length-1;
        while(reader>=0){
                if(arr[reader]!=0){
                    arr[writer]=arr[reader];
                    writer--;
                }
                reader--;
        }
        for (int i = writer; i >= 0; i--) {
            arr[i]=0;
        }

        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }

    private static void swap(int[] arr, int len, int i) {
        int temp = arr[len];
        arr[len] = arr[i];
        arr[i] = temp;
    }
}
