package com.practice.Recursion.Subset;

import java.util.ArrayList;
import java.util.List;

public class NoOfSubsetAddition {

    public static void main(String[] args) {
        int[] arr={3,1,2};
        List list=new ArrayList<Integer>();

        findNoOfPossibleSubsets(0,arr,list,0);
        list.forEach(x-> System.out.print(x+" "));
        System.out.println();
    }

    private static void findNoOfPossibleSubsets(int index, int[] arr, List<Integer> list, int sum) {
        if(index==arr.length){
            list.add(sum);
            return;
        }
        findNoOfPossibleSubsets(index+1,arr,list,sum+arr[index]);

        findNoOfPossibleSubsets(index+1,arr,list,sum);
    }
}
