package com.practice;

public class GCD {
    int n,a[]=new int[10];
    public static void main(String[] args) {
        int[] b = {2, 18,3, 6, 9, 5};
        int l = 1; // Starting index of range.
        int r = 4; //Last index of range.
        calculateInRange(b,l,r);

    }
    static void calculateInRange(int[] b, int l, int r){
        int i,g =b[l];
        for (i = l; i< r; i++) {
            g=gcd(g,b[i]);
        }
        System.out.println("g:"+g);
    }

    private static int gcd(int g, int i) {
        while (g!=i){
            if(g>i)
                g=g-i;
            else
                i=i-g;
        }
        return g;
    }
}
