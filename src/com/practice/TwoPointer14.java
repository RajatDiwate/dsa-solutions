package com.practice;

/**
 * Two Pointers Technique
 * Two pointers is really an easy and effective technique that is typically used for searching pairs in a sorted array.
 * Given a sorted array A (sorted in ascending order), having N integers, find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.
 * A[] = {10, 20, 35, 50, 75, 80}
 * X = =70
 * A[i] + A[j] = 20 + 50 = 70
 */
public class TwoPointer14 {

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 8, 9, 10, 11};
        int val = 17;
        int i = 0;
        int j = arr.length - 1;
        int output = 0;
        while (i < j) {
            if (arr[i] + arr[j] == val) {
                output = 1;
                break;
            } else if (arr[i] + arr[j] < val) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(output);

    }
}
