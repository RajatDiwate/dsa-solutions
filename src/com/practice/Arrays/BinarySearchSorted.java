package com.practice.Arrays;
//Sorted Array
public class BinarySearchSorted {
    public static void main(String[] args) {
        int[] num = {1, 5, 6, 7, 8, 9};
        int target = 8;
        int result = binarySearch(num, target);
        System.out.println(result);
    }

    private static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;

            } else if (nums[mid] < target)
                low = mid + 1;
        }

        return -1;
    }

}
