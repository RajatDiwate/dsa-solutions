package com.practice;

public class ShortestUnsortedArr13 {
    public static void main(String[] args) {
        int arr[] = new int[]{7, 9, 10, 8, 11};
        boolean flag=false;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>=arr[i+1]){
                    flag=true;
            }
        }
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]<arr[i+1]){
                flag=!flag;
            }
        }
        if(flag){
            System.out.println(0);
        }else{
            System.out.println(3);
        }
    }
}
