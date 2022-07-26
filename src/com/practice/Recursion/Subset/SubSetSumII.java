package com.practice.Recursion.Subset;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11
public class SubSetSumII {

    public static void main(String[] args) {
        int arr[] = {1, 2, 2};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        findSubsetSum2(0, arr, newList, result);
        result.forEach(x-> System.out.println(x+" "));
    }

    private static void findSubsetSum2(int index, int[] arr, List<Integer> newList, List<List<Integer>> result) {
        result.add(new ArrayList<>(newList));
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1]) {
                continue;
            }
            newList.add(arr[i]);
            findSubsetSum2(i+1,arr,newList,result);
            newList.remove(Integer.valueOf(arr[i]));
        }

    }
}
