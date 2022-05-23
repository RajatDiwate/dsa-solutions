package com.practice;

public class SpiralMatrix16 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        //Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        int m = arr.length;
        int n = arr[0].length;
        int k = 0, l = 0;
        int i;
        while (k < m && l < n) {
            for (i = l; i < m; i++) {
                System.out.print(arr[k][i] + " ");
            }
            k++;
            for (i = k; i < m; i++) {
                System.out.print(arr[i][n - 1] + " ");
            }
            n--;
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(arr[m - 1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining
            // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(arr [i][l] + " ");
                }
                l++;
            }
        }
    }
}
