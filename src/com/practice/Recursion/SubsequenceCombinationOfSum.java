package com.practice.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceCombinationOfSum {
    public static void main(String[] args) {
        int target = 7;
        int[] arr = {2, 3, 6, 7};
        combinationSum(arr, target).forEach(System.out::println);
    }

    private static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        findCombinations(0, arr, target, arrayLists, new ArrayList<Integer>());
        return arrayLists;
    }

    private static void findCombinations(int i, int[] arr, int target, List<List<Integer>> arrayLists, ArrayList<Integer> newList) {
        if (i == arr.length) {
            if (target == 0) {
                arrayLists.add(new ArrayList<>(newList));
            }
            return;
        }
        if (arr[i] <= target) {
            newList.add(arr[i]);
            findCombinations(i,arr,target-arr[i],arrayLists,newList);
            newList.remove(Integer.valueOf(arr[i]));
        }
        findCombinations(i+1,arr,target,arrayLists,newList);
    }
}
