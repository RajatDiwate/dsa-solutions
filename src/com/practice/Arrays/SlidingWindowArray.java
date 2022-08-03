package com.practice.Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowArray {
    public static void main(String[] args) {
        int[] arr = {-4, 2, -5, 1, -1, 6};
        int window = 3;
        ArrayDeque<Integer> result = findMaxFromSlidingWindow(arr, window);
        result.forEach(x-> System.out.print(x+" "));
    }

    private static ArrayDeque<Integer> findMaxFromSlidingWindow(int[] arr, int window) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        Deque<Integer> list = new ArrayDeque<>();
        if (window > arr.length) {
            window = arr.length;
        }

        for (int i = 0; i < window; i++) {
            while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                list.removeLast();
            }
            list.addLast(i);
        }

        for (int i = window; i < arr.length ; i++) {
            result.add(arr[list.peek()]);
            while(!list.isEmpty() && list.peek() <= i-window){
                list.removeFirst();
            }
            while (!list.isEmpty() && arr[i]>=arr[list.peekLast()]){
                list.removeLast();
            }
            list.add(i);
        }
        result.add(arr[list.peek()]);
        return result;
    }
}
