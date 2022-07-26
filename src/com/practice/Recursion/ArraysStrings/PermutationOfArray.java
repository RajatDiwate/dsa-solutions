package com.practice.Recursion.ArraysStrings;

import java.util.ArrayList;
import java.util.List;

//L12. Print all Permutations of a String/Array | Recursion | Approach - 1
//https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12
public class PermutationOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> resultList = new ArrayList<>();
        findAllPermutation(new ArrayList<>(), arr, resultList,new boolean[arr.length]);
        for (List<Integer> integers : resultList) {
            integers.forEach(System.out::print);
            System.out.println();
        }

    }

    private static void findAllPermutation(ArrayList<Integer> ds, int[] arr, List<List<Integer>> resultList,boolean[] freq) {
        if (ds.size() == arr.length) {
            resultList.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!freq[i]) {
                freq[i]=true;
                ds.add(arr[i]);
                findAllPermutation(ds, arr, resultList,freq);
                ds.remove(Integer.valueOf(arr[i]));
                freq[i]=false;
            }
        }
    }
}
