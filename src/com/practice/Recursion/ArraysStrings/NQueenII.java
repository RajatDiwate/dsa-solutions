package com.practice.Recursion.ArraysStrings;

import java.util.ArrayList;
import java.util.List;

public class NQueenII {
    public static void main(String[] args) {
        int N = 4;
        List<List<String>> result = solveNQueens(N);
        for (List<String> strings : result) {
            System.out.println("Arrangment:");
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println("---------");
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        int leftRow[] = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }

    private static void solve(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if (col == board.length) {
            res.add(compute(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col]='Q';
                leftRow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[board.length-1 + col-row]=1;
                solve(col+1,board,res,leftRow,lowerDiagonal,upperDiagonal);
                board[row][col]='.';
                leftRow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[board.length-1 + col-row]=0;
            }
        }


    }

    private static List<String> compute(char[][] board) {
        List<String> boardList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            boardList.add(String.valueOf(board[i]));
        }
        return boardList;
    }
}
