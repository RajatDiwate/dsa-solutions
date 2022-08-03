package com.practice.test;

public class MergeArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5};
        int[] arr2 = {2, 6, 7, 8};
        final int[] ints = mergeArrays(arr1, arr2);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] finalArr = new int[arr1.length + arr2.length];
        int arrIdx1 = 0, arrIdx2 = 0,arrIdxF=0;
        while (arr1.length>arrIdx1 && arr2.length>arrIdx2) {
                if (arr1[arrIdx1] > arr2[arrIdx2]) {
                    finalArr[arrIdxF++] = arr2[arrIdx2++];

                } else {
                    finalArr[arrIdxF++] = arr1[arrIdx1++];

            }
        }
        while (arr1.length>arrIdx1)
            finalArr[arrIdxF++] = arr1[arrIdx1++];

        while (arr2.length>arrIdx2)
            finalArr[arrIdxF++] = arr2[arrIdx2++];

        return finalArr; // make a new resultant array and return your results in that
    }

}
