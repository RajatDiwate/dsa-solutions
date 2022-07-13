package com.practice.Recursion;

public class FibonacciSequence {
    //nth elemtnt in fibonaccci
    public static void main(String[] args) {
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 8
        printFirstFibonacciSeries(10);
        System.out.println("------------");
        printFibonacciUsingRecursion(10);
        System.out.println();
        //nth elemtnt in fibonaccci
        System.out.println("----------");
        System.out.println(nThEleOfFinbo(4));
    }

    private static int nThEleOfFinbo(int i) {
        if (i <= 1) {
            return i;
        }
        int last = nThEleOfFinbo(i - 1);
        int second = nThEleOfFinbo(i - 2);
        return last + second;
    }

    private static void printFibonacciUsingRecursion(int inputData) {
        for (int i = 0; i < inputData; i++) {
            System.out.print(recursiveFibonacci(i) + " ");
        }
    }

    private static int recursiveFibonacci(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return 1;
        }
        return recursiveFibonacci(i - 1) + recursiveFibonacci(i - 2);
    }

    private static void printFirstFibonacciSeries(int inputData) {
        int n1 = 0, n2 = 1, n3 = 0;
        System.out.print(n1 + " " + n2 + " ");
        for (int i = 2; i < inputData; i++) {
            n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
    }

}
