package com.practice.Recursion;

import java.util.ArrayList;
import java.util.List;

//contwe3gious and non contegiods which folows the order
//sub array is only contigious but sub sequence is con as well as non contegios
//This solution array sould not containt duplicate
public class Subsequence {

    public static void main(String[] args) {
        int[] arr={3,1,2};
        int len= arr.length;
        List<Integer> integerList=new ArrayList<>();
        printSubSeq(0,integerList,arr,len);
    }

    private static void printSubSeq(int n, List<Integer> newArr, int[] arr, int len) {
        if(n==len){
            newArr.forEach(System.out::print);
            if(newArr.isEmpty()){
                System.out.println("{}");
            }
            System.out.println();
            return;
        }
        newArr.add(arr[n]);
        printSubSeq(n+1,newArr,arr,len);
        newArr.remove(Integer.valueOf(arr[n]));
        printSubSeq(n+1,newArr,arr,len);
    }
}
