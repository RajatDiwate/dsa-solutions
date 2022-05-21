package com.practice;

/*
        Count minimum steps to get the given desired array //count number of operation required from {0,0} to target
        target[] = {2, 3}
        Output: 4
        To get the target array from {0, 0}, we
        first increment both elements by 1 (2
        operations), then double the array (1
        operation). Finally increment second
        element (1 more operation)
 */
public class CountMinimumSteps {
    static int arr[] = new int[]{16, 17, 16};

    public static void main(String[] args) {
        getMinOps(); //Simple first try
        //System.out.println("Solution by GFG"+countMinOperationsGFG(arr.length)); //GFG
    }

    private static void getMinOps() {
        int result = 0;

        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] % 2 != 0) {
                arr[j] = arr[j] - 1;
                result++;
            }
            while (arr[j] % 2 == 0)
                arr[i] = arr[i] / 2;
            result++;
            if(arr[j]==1){
                arr[j]--;
                result++;
            }
            j++;
            i++;
        }
        for (int f = 0; f < arr.length; f++) {
            System.out.println(arr[f]);

        }
        System.out.println(result);
    }

    static int countMinOperationsGFG(int n) {
        int result = 0;

        while (true) {
            int zero_count = 0;

            int i;  // To find first odd element
            for (i = 0; i < n; i++) {
                if (arr[i] % 2 == 1)
                    break;

                else if (arr[i] == 0)
                    zero_count++;
            }

            if (zero_count == n)
                return result;

            if (i == n) {
                for (int j = 0; j < n; j++)
                    arr[j] = arr[j] / 2;
                result++;
            }

            for (int j = i; j < n; j++) {
                if (arr[j] % 2 == 1) {
                    arr[j]--;
                    result++;
                }
            }
        }
    }
}
