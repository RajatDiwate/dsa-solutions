package com.practice.Recursion.ArraysStrings;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=13
//L13. Print all Permutations of a String/Array | Recursion | Approach - 2
public class PermutationOfArrayII {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> resultList=new ArrayList<>();
        findAllPermutationUsingSwap(0,arr,resultList);
        resultList.forEach(x-> {
            x.forEach(System.out::print);
            System.out.println();
        });
        System.out.println(42+25+"ss");
    }

    private static void findAllPermutationUsingSwap(int index, int[] arr, List<List<Integer>> resultList) {
        if(arr.length==index){
            List<Integer> ds=new ArrayList<>();
            for (int j : arr) {
                ds.add(j);
            }
            resultList.add(ds);
        }

        for (int i = index; i < arr.length; i++) {
            swap(i,index,arr);
            findAllPermutationUsingSwap(index+1,arr,resultList);
            swap(index,i,arr);
        }

    }

    private static void swap(int i, int index, int[] arr) {
        int temp=arr[i];
        arr[i]=arr[index];
        arr[index]=temp;
    }
}
