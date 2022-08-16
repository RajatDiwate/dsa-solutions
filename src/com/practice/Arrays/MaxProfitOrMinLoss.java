package com.practice.Arrays;

public class MaxProfitOrMinLoss {
    public static void main(String[] args) {
        int[] buySellArr={7, 1, 5, 3, 6, 4};
        int currentProfit=Integer.MIN_VALUE;
        int currentBuy=buySellArr[0];
        int globalSell=buySellArr[1];
        int globalProfit=globalSell-currentBuy;
        for (int i = 1; i < buySellArr.length; i++) {
            currentProfit=buySellArr[i]-currentBuy;

            if(currentProfit>globalProfit){
                globalProfit=currentProfit;
                globalSell=buySellArr[i];
            }

            if(currentBuy>buySellArr[i]){
                currentBuy=buySellArr[i];
            }
        }
        int r1=globalSell-globalProfit;
        int sell=globalSell;
        System.out.println("r1:"+r1);

        System.out.println("globalsell:"+sell);

    }
}
