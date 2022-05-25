package com.practice;

/**
 * Given a matrix of N * M. Find the maximum path sum in matrix. The maximum path is sum of all elements from first row to last row where you are allowed to move only down or diagonally to left or right. You can start from any element in first row.
 */
public class MaxPathSumMatrix {
    public static void main(String[] args) {
        int arr[][] = {{10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4}
        };

        int arr2[][] = {{1, 2, 3},
                {9, 8, 7}
                , {4, 5, 6}};
        int maxSum = 0;
        int i, j;
        int counteri = 0, counterj = 0;
        for (i = 0; i < arr[0].length; i++) {
            if (maxSum < arr[counteri][i]) {
                maxSum = arr[counteri][i];
                counterj = i;
            }
        }
        counteri++;
        while (counteri < arr.length && counterj < arr[0].length && counterj >= 0) {
            if(counterj== arr.length-1){
                maxSum = maxSum + arr[counteri][counterj - 1];
                counteri++;
                counterj--;
                continue;
            }
            if (arr[counteri][counterj + 1] > arr[counteri][counterj - 1]) {
                maxSum = maxSum + arr[counteri][counterj + 1];
                counteri++;
                counterj++;
            } else {
                maxSum = maxSum + arr[counteri][counterj - 1];
                counteri++;
                counterj--;
            }
        }


        System.out.println(maxSum);


    }
}
