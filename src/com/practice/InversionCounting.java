package com.practice;

/**\
 * Input: arr[] = {8, 4, 2, 1}
 * Output: 6
 *
 * Explanation: Given array has six inversions:
 * (8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).
 */
public class InversionCounting {
    public static void main(String[] args) {
       int  arr[] = {8, 4, 2, 1};
       int counter=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]<arr[j]){
                    counter++;
                }
            }
        }
        System.out.println("-");
        System.out.println(counter);
    }
}
