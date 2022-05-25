package com.practice;

/**
 * Rearrange array in alternating positive & negative items with O(1) extra space
 */
public class RearrangePositiveNeg {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, -4, -1, 4};
        int arr2[] = {-5, -3, -4, -5, -6,
                2, 8, 9, 1, 4};
        int arr3[] = {5, 3, 4, 2, 1,
                -2, -8, -9, -1, -4};
        int arr4[] = {-5, 3, -4, -7,
                -1, -2, -8, -9, 1, -4};
        int arr9[] = {-5, -2, 5, 2, 4,
                7, 1, 8, 0, -8};

        System.out.println();
        int[] posArr = new int[arr.length];
        int negN = arr.length - 1;
        int posN = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                posArr[negN] = arr[i];
                negN--;
            } else {
                posArr[posN] = arr[i];
                posN++;
            }
        }
        negN = arr.length - 1;
        posN = 0;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (flag && posArr[negN] < 0) {
                arr[i] = posArr[negN];
                negN--;
            } else {
                arr[i] = posArr[posN];
                posN++;
            }
            flag = !flag;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
