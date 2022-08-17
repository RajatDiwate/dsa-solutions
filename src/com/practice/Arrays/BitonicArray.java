package com.practice.Arrays;

import java.util.stream.IntStream;

//array which start with ascending till middle then start desending order or vice versa OR may be just Ascending or descendign
public class BitonicArray {
    public static void main(String[] args) {
            int[] arr= {1, 3, 8, 12, 4, 2 };
            int max=findMax(arr);
        System.out.println(max);
    }

    private static int findMax(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+((end-start)/2);
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return arr[start];
    }
}
