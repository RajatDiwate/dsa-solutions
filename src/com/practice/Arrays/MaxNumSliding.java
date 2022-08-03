package com.practice.Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxNumSliding {
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int window=3;
        int [] arr2=new int[arr.length-2];
        for (int i = 0; i < arr.length-2; i++) {
            arr2[i]=getMaxOfAll2(i,arr,window);
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
        System.out.println("");
        System.out.println("[3, 4, 5, 6, 7, 8, 9, 10]");
        int[] arr1={-4,2,-5,1,-1,6};
        findMaxSlidingWindow(arr1,window);

    }

    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>(); // ArrayDeque for storing values
        Deque<Integer> list = new ArrayDeque<Integer>(); // creating a linked list

        if (arr.length > 0) {
            // If window_size is greater than the array size,
            // set the window_size to nums.size()
            if (arr.length < windowSize)
                windowSize = arr.length;
            for (int i = 0; i < windowSize; ++i) {
                // Removing last smallest element index
                while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                    list.removeLast();
                }

                // Adding newly picked element index
                list.addLast(i);
            }

            for (int i = windowSize; i < arr.length; ++i) {
                result.add(arr[list.peek()]);

                // Removing all the elements indexes which are not in the current window
                while ((!list.isEmpty()) && list.peek() <= i - windowSize)
                    list.removeFirst();

                // Removing the smaller elements indexes which are not required
                while ((!list.isEmpty()) && arr[i] >= arr[list.peekLast()])
                    list.removeLast();

                // Adding newly picked element index
                list.addLast(i);
            }

            // Adding the max number of the current window in the result
            result.add(arr[list.peek()]);
            return result; // returning result
        } else
            return result;
    }


    private static int getMaxOfAll(int i, int i1, int i2) {
        i=Math.max(i,i1);
        i=Math.max(i,i2);
        return i;
    }
    private static int getMaxOfAll2(int i,int[] arr,int window) {
        int max=arr[i];
        for (int j = 1; j < window; j++) {
            max=Math.max(max,arr[i+j]);
        }
        return max;
    }
}
