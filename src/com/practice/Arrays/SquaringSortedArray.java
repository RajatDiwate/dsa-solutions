package com.practice.Arrays;

public class SquaringSortedArray {
    public static void main(String[] args) {
        int[] arr = {-3, -2, 0, 1, 5, 9};
        int[] sqrd = sortSquaredArray(arr);
        for (int i : sqrd) {
            System.out.print(i + " ");
        }
    }

    private static int[] sortSquaredArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int lowPtr = 0, highPtr = 0;
        int highIndx = arr.length - 1;
        int[] sqrdSum = new int[arr.length];
        while (i <= j) {
            lowPtr = arr[i] * arr[i];
            highPtr = arr[j] * arr[j];
            if (lowPtr > highPtr) {
                sqrdSum[highIndx--] = lowPtr;
                i++;
            } else {
                sqrdSum[highIndx--] = highPtr;
                j--;
            }
        }
        return sqrdSum;
    }
}
