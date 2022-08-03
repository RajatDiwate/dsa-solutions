package com.practice.Recursion.ArraysStrings;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/
public class NQueen {
    public static void main(String[] args) {
        int N = 4;
        long l = System.nanoTime();
        List<List<String>> resultList = solveNQueens(N);
        long l2 = System.nanoTime();

        System.out.println("~~~~~~~~~~~");
        for (List<String> strings : resultList) {
            System.out.println("Arrangment:");
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println("---------");
        }
        System.out.println(l2-l);
    }

    private static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        dfs(0, board, result);
        return result;
    }

    private static void dfs(int col, char[][] board, List<List<String>> result) {
        if (col == board.length) {
            result.add(compute(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col]='Q';
                dfs(col+1,board,result);
                board[row][col]='.';
            }
        }
    }

    private static boolean validate(char[][] board, int row, int col) {
        int tempRow = row;
        int tempCol = col;
        while (tempCol >= 0 && tempRow >= 0) {
            if (board[tempRow][tempCol] == 'Q') return false;
            tempCol--;
            tempRow--;
        }
        tempRow = row;
        tempCol = col;
        while (tempCol >= 0) {
            if (board[tempRow][tempCol] == 'Q') return false;
            tempCol--;
        }
        tempRow = row;
        tempCol = col;
        while (tempCol >= 0 && tempRow < board.length) {
            if (board[tempRow][tempCol] == 'Q') return false;
            tempCol--;
            tempRow++;
        }
        return true;
    }

    private static List<String> compute(char[][] board) {
        List<String> boardList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            boardList.add(String.valueOf(board[i]));
        }
        return boardList;
    }
}
