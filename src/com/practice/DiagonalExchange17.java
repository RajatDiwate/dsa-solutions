package com.practice;

/**
 * Assumed array has a fixed size
 * if it has a fixed size then no iteration is required
 */
public class DiagonalExchange17 {
    public static void main(String[] args) {
        int matrix[][] = {{0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}};
        int length = matrix.length;
        int a = matrix[0][0];
        matrix[0][0] = matrix[0][length - 1];
        matrix[0][length - 1] = a;

        int b = matrix[length - 1][0];
        matrix[length - 1][0]= matrix[length-1][length-1];
        matrix[length-1][length-1]=b;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
