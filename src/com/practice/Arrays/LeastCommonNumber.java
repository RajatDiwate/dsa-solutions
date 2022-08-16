package com.practice.Arrays;

public class LeastCommonNumber {
    public static void main(String[] args) {
        int[] arr1={6,7,10,25,30,63,45};
        int[] arr2={0,4,5,6,7,8,20};
        int[] arr3={1,6,10,14};
        Integer result=findLeastCommonValue(arr1,arr2,arr3);
        System.out.println(result);
    }

    private static Integer findLeastCommonValue(int[] arr1, int[] arr2, int[] arr3) {
        int n1=0,n2=0,n3= 0;
        while (n1< arr1.length && n2< arr2.length && n3< arr3.length){
            if(arr1[n1]==arr2[n2]&& arr2[n2]==arr3[n3]){
                return arr1[n1];
            }
            if(arr1[n1]<=arr2[n2] && arr1[n1]<=arr3[n3]){
                n1++;
            }else if(arr2[n2]<=arr1[n1]&& arr2[n2]<=arr3[n3]){
                n2++;
            }else if(arr3[n3]<=arr1[n1]&& arr3[n3]<=arr2[n2]){
                n3++;
            }
        }
        return -1;
    }
}
