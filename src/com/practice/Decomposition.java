package com.practice;

public class Decomposition {
    static int arr2[] = new int[1000];
    static int blockArr[] = new int[100];//8,11,15
    static int MAXN = 10000;
    static int SQRSIZE = 100;

    static int[] arr = new int[MAXN];             // original array
    static int[] block = new int[SQRSIZE];         // decomposed array
    static int blk_sz;

    public static void main(String... args) {
        int[] input = {1, 5, 2, 4, 6, 1, 3, 5, 7};
                      //8,      11,       15
        int n = input.length;
        preprocessor(input, n);
        System.out.println();
        preprocess(input, n);
        System.out.println("query(3, 8) : " +
                search(3, 8));
        System.out.println("query(1, 6) : " +
                search(1, 6));
        update(8, 0);
        System.out.println("query(8, 8) : " +
                search(6, 8));


    }
    private static void update(int index,int value){
        int blockNumber=index/blk_sz;
        block[blockNumber]+= value-arr[index];
        arr[index]=value;
    }

    private static int search(int l, int r) {
        int sum=0;
        while(l<r && l%blk_sz!=0 && l!=0){
            sum+=arr[l];
            l++;
        }
        System.out.print("blk:"+blk_sz);
        while( l+blk_sz<=r){
            sum+=blockArr[l/blk_sz];
            l=l+blk_sz;
        }

        while(l<=r){
            sum+=arr[l];
            l++;
        }

        return sum;
    }

    private static void preprocessor(int[] arr, int n) {
        int j = 0, k = 1;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 0; i < n; i++) {
            Decomposition.arr[i]=arr[i];
            if (k > sqrt) {
                j++;
                k = 1;
            }
            blockArr[j] += arr[i];
            k++;
        }
    }

    static void preprocess(int input[], int n) {
        int blk_idx = -1;

        blk_sz = (int) Math.sqrt(n);

        for (int i = 0; i < n; i++) {
            arr[i] = input[i];
            if (i % blk_sz == 0) {
                blk_idx++;
            }
            block[blk_idx] += arr[i];
        }
    }
}
