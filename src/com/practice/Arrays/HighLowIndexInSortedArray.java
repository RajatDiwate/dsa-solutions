package com.practice.Arrays;

public class HighLowIndexInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2,2,3, 3, 3, 3, 4, 5, 5, 6, 6, 6, 6, 6, 6};
        int low = findLowIndexBinaryForm(arr, 5);
        System.out.println(low);
        int high=findHighIndexBinaryForm(arr,3);
        System.out.println(high);
    }

    private static int findHighIndexBinaryForm(int[] arr, int target) {
        int low=0;
        int high=arr.length-1;
        int mid=high/2;
        while(low<=high){
            int midEle=arr[mid];
            if(midEle<=target){
                low= mid+1;
            }else{
                high=mid-1;
            }
            mid=low+((high-low)/2);
        }
        if (high == -1) {
            return high;
        }

        if (high < arr.length && arr[high] == target) {
            return high;
        }

        return -1;
    }

    private static int findLowIndexBinaryForm(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid = low + ((high - low) / 2);
        while (low <= high) {
            int midEle = arr[mid];
            if (midEle < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + ((high - low) / 2);
        }
        if (low < arr.length && arr[low] == target) {
            return low;
        }
        return -1;
    }
}
