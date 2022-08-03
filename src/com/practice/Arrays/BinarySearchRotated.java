package com.practice.Arrays;

public class BinarySearchRotated {
    public static void main(String[] args) {
        int[] arr = {6, 7, 1, 2, 3, 4, 5};
        int target = 6;
        int result = binaryUnsortedArray(arr, target);
        int resultRecursion = binaryUnsortedArrayRecursive(arr, target);
        System.out.println(result==resultRecursion);
    }

    private static int binaryUnsortedArrayRecursive(int[] arr, int target) {
        return binarySortUsingRecursion(0, arr.length - 1, arr, target);
    }

    private static int binarySortUsingRecursion(int start, int end, int[] arr, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) / 2);
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[start] <= arr[mid]){
            if(target>=arr[start] && target<arr[mid]){
                return binarySortUsingRecursion(start,mid-1,arr,target);
            }else{
                return binarySortUsingRecursion(mid+1,end,arr,target);
            }
        }else if(target>arr[mid] && target <= arr[end]){
            return binarySortUsingRecursion(mid+1,end,arr,target);
        }else{
            return binarySortUsingRecursion(start,mid-1,arr,target);
        }
    }

    private static int binaryUnsortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start >= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }
        }
        return 0;
    }
}
