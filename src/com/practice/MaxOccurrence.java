package com.practice;

/**
 * Input : arr[] = {-5, -5, 2, 2, 2, 2, 3, 7, 7, 7}
 *         Query 1: start = 0, end = 9
 *         Query 2: start = 4, end = 9
 * Output : 4
 *          3
 *Explanation:
 * Query 1: '2' occurred the most number of times
 * with a frequency of 4 within given range.
 * Query 2: '7' occurred the most number of times
 * with a frequency of 3 within given range.
 */
public class MaxOccurrence {
    public static void main(String[] args) {
        int[] arr = {-5, -5, 2, 2, 2, 2, 3, 7, 7, 7};
        int maxCount=0,num;
        int outMax=0;
        int start=0;
        int end=arr.length-1;
        start=4;
        end=9;
        //index based
        for (int i = start; i <= end; i++) {
            num=arr[i];
            for (int j = start+1; j <= end; j++) {
                    if(num==arr[j]){
                        maxCount++;
                    }
            }
            if(maxCount>outMax){
                outMax=maxCount;
            }
            maxCount=0;
        }

        System.out.println(outMax);
    }
}
