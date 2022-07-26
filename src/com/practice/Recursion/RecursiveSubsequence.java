package com.practice.Recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSubsequence {
    public static void main(String[] args) {
        int[]  arr={1,1,1,2,2};
        List<Integer> list=new ArrayList<>();
        int target=4;
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
        computeSubSequenceAddition(0,target,list,arr,arrayLists,arr.length);
        arrayLists.forEach(System.out::println);
    }

    private static void computeSubSequenceAddition(int i, int target, List<Integer> list, int[] arr, ArrayList<ArrayList<Integer>> arrayLists, int length) {
        if(target==0){
            arrayLists.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < length; j++) {
            if(j>i && arr[j]==arr[j-1]) continue;
            if(arr[j]>target) break;
            list.add(arr[j]);
            computeSubSequenceAddition(j+1,target-arr[j],list,arr,arrayLists,length);
            list.remove(Integer.valueOf(arr[j]));
        }
    }
}
