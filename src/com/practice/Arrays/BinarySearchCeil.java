package com.practice.Arrays;

import java.util.stream.IntStream;

public class BinarySearchCeil {
    public static void main(String[] args) {
        int[] arr= {1,4,6,7,9,12,13};
        int ceilNo=10;
        int index=getMaxNearbyFromArray(arr,ceilNo);
        System.out.println(arr[index]);
    }

    private static int getMaxNearbyFromArray(int[] arr, int ceilNo) {
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+((high-low)/2);
            int midEle=arr[mid];
            if(arr[mid]>ceilNo){
                high=mid-1;
            }else if(arr[mid]<ceilNo){
                low=mid+1;
            }else{
              return mid;
            }
        }
        return low;
    }
}
