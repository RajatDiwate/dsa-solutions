package ProblemSolving.array.problems;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.IntStream;

public class BasicArrays {
    public static void main(String[] args) {
        /*------------------------------------------------------------------------------**/

        //Q1 Extract non evenNumbers
        int[] arr = IntStream.range(1, 11).toArray();
        int[] evenNumbers = removeEvenNumbers(arr);
        // printArray(evenNumbers);
        /*------------------------------------------------------------------------------**/

        //Q2 mergeArrays two arrays
        int[] arr1 = {1, 12, 14, 17, 23};
        int[] arr2 = {11, 19, 27};
        int[] mergeArrays = mergeArrays(arr1, arr2);
        // printArray(mergeArrays);
        /*------------------------------------------------------------------------------**/

        //Q3 Find Two Numbers that Add up to "n"
        arr = new int[]{1, 21, 3, 14, 5, 60, 7, 6};//27 found
        // arr = new int[]{9, 4, 7, 2, 6};//17 not found
        int[] summation = findSum(arr, 27);
        //printArray(summation); //Complexity == O(n^2)
        summation = findSumSorted(arr, 27);
        //printArray(summation);  //  O(nlogn)
        /*------------------------------------------------------------------------------**/

        //Q4  Array of Products of All Elements Except Itself
        // arr = {1,2,3,4} ==>  arr = {24,12,8,6}
        arr = new int[]{1, 2, 3, 4};
        //arr = new int[]{4, 2, 1, 5, 0};
        //arr = new int[]{-1, 2, -3, 4, -5};
        int[] rest = findProductOfRest(arr);
        //printArray(rest);
        /*------------------------------------------------------------------------------**/

        //Q5 First Non-Repeating Integer in an Array
        //->arr = {9, 2, 3, 2, 6, 6} ==> 9
        arr = new int[]{9, 3, 9, 2, 6, 6};
        int firstUnique = findFirstUnique(arr);
        //System.out.println(firstUnique);
        /*------------------------------------------------------------------------------**/

        //Q6 Find Second Maximum Value in an Array
        arr = new int[]{9, 2, 10, 6}; // 9
        //arr=new int[]{-2, -33, -10, -456}; ==> -10
        int secondMaximum = findSecondMaximum(arr);
        // System.out.println(secondMaximum);
        /*------------------------------------------------------------------------------**/

        //Q7 Right Rotate the Array by One Index
        //arr = {1, 2, 3, 4, 5}==> arr = {5, 1, 2, 3, 4}
        arr = new int[]{1, 2, 3, 4, 5};
        rotateArray(arr);
        //printArray(arr);
        /*------------------------------------------------------------------------------**/

        //Q8 Re-arrange Positive & Negative Values
        //arr = {10, -1, 20, 4, 5, -9, -6}==>arr = {-1, -9, -6, 10, 20, 4, 5}
        arr = new int[]{10, -1, 20, 4, 5, -9, -6};
        int[] reArrange = reArrange(arr);//Solution 1
        reArrangeInPlace(arr);// Inplace solution
        //printArray(arr);
        /*------------------------------------------------------------------------------**/

//!       //Q9 10: Rearrange Sorted Array in Max/Min Form
        //arr = {1, 2, 3, 4, 5}==>arr = {5, 1, 4, 2, 3}
        arr = new int[]{1, 2, 3, 4, 5};
        // Solution 1 -> with new array
        reArrangeMaxMinForm(arr); //Inplace
        //printArray(arr);
        /*------------------------------------------------------------------------------**/

        //Q9 11: Find the Sum of Maximum Sum SubArray
        //arr = {1, 7, -2, -5, 10, -1}==>11
        arr = new int[]{1, 7, -2, -5, 10, -1};
        //Kadanes Algorithm
        int maxSumSubArray = findMaxSumSubArray(arr);
        //System.out.println(maxSumSubArray);
        /*------------------------------------------------------------------------------**/

        //Q9 Implement Binary Search on a Sorted Array
        //nums = [1, 3, 9, 10, 12] target = 9  ==>2
        arr = new int[]{1, 3, 9, 10, 12};
        int target = 9;
        int eleIdx = findEleUsingBinarySearch(arr, target); //Normal
        //System.out.println(eleIdx);
        eleIdx = findEleBinarySearch(arr, target); //Recursicve Approcah
        //System.out.println(eleIdx);
        /*------------------------------------------------------------------------------**/

//!     //Q9 Find Maximum in Sliding Window
        //nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        //window_size = 3m    ==>[3, 4, 5, 6, 7, 8, 9, 10] -->  [1, 2, 3==> (3) ,2, 3, 4==> (4)]
        arr = new int[]{10, 6, 9, -3, 23, -1, 34, 56, 67, -1};
        //10 9 9 23 23 34 56 67 67 -1 -4 -2 9 10 34 67
        int window = 2;
        int[] result = SlidingWindowMaximum(arr, window);//Optimized
        result = findMaxSlidingWindow(arr, window);//normal
        // printArray(result);
        /*------------------------------------------------------------------------------**/

//!     //Q9 Search  in a Rotated Array using binary search
        //nums = [6, 7, 1, 2, 3, 4, 5]  target = 3 ===> 4
        arr = new int[]{6, 7, 1, 2, 3, 4, 5};
        arr = new int[]{3, 4, 5, 6, 7, 2, 1};
        target = 7;
        eleIdx = findInRotatedArray(arr, target);
        //System.out.println(eleIdx);
        /*------------------------------------------------------------------------------**/

//!     //Q9 Find the Smallest Common Number in list of 3 arrays
        arr1 = new int[]{6, 7, 10, 25, 30, 63, 64};
        arr2 = new int[]{0, 4, 5, 6, 7, 8, 50};
        int[] arr3 = new int[]{1, 6, 10, 14};
        int commonEle = findLeastCommonNumber(arr1, arr2, arr3);
        //System.out.println(commonEle);
        /*------------------------------------------------------------------------------**/

//!     //Q9 Find Low/High Index of an Element in a Sorted Array
        //nums = [1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6] t=5==> Low index: 15 High index: 17
        arr = new int[]{1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        arr = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6};
        target = 5;
        int highIdx = findHighIndex(arr, target);
        //System.out.println(highIdx);
        int lowIdx = findMinIndex(arr, target);
        //System.out.println(lowIdx);
        /*------------------------------------------------------------------------------**/

//!     //Q9 Move All Zeros to the Beginning of the Array
        arr = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
        moveZerosToLeft(arr);
        //printArray(arr);
        /*------------------------------------------------------------------------------**/

//!     //Q9 Stock Buy Sell to Maximize Profit
        arr = new int[]{7, 1, 5, 3, 6, 4};
        result = stockBuySell(arr);
        // printArray(result);
        /*------------------------------------------------------------------------------**/

//!     //Q9 Merge an Array With Overlapping Intervals
        List<Interval> matrix = Arrays.asList(new Interval(1, 5), new Interval(3, 7), new Interval(4, 6));
        List<Interval> matrixResult = mergeIntervals(matrix);
        StringBuilder result_str = new StringBuilder();
        for (Interval interval : matrixResult) {
            result_str.append("[").append(interval.start).append(", ").append(interval.end).append("] ");
        }
        // System.out.println(result_str);
        /*------------------------------------------------------------------------------**/

//!     //Q9 Sort an Array Using Quicksort Algorithm
        arr = new int[]{7, 1, 5, 3, 6, 4};
        quickSort(arr, 0, arr.length - 1);
        //printArray(arr);
        /*------------------------------------------------------------------------------**/

//!     //Q9 Cyclic Sort (easy)
//        Input: [3, 1, 5, 4, 2]
//        Output: [1, 2, 3, 4, 5]
        arr = new int[]{3, 1, 5, 4, 2};
        cyclicSort(arr);
        //printArray(arr);
        /*------------------------------------------------------------------------------**/

//!     //Q9 maximum sum of any contiguous subarray of size ‘k’.
        /*
        Input: [2, 1, 5, 1, 3, 2], k=3
        Output: 9
        Explanation: Subarray with maximum sum is [5, 1, 3].
         */
        arr = new int[]{2, 1, 5, 1, 3, 2};
        window = 3;
        int maxSum = findMaxSumSubArrayWithWindow(arr, window);
        //System.out.println(maxSum);
        /*------------------------------------------------------------------------------**/

//!     //Q9 smallest contiguous subarray whose sum is greater than or equal to ‘S’.
        /*
        Input: [2, 1, 5, 2, 3, 2], S=7
        Output: 2
        Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
        */
        arr = new int[]{2, 1, 5, 2, 3, 2};
        int sum = 7;
        int minimumLength = smallestSubArraySum(arr, sum);
        //System.out.println(minimumLength);
        /*------------------------------------------------------------------------------**/

//!     //Q10 squares of all the numbers of the input array in the sorted order.
        /*  Input: [-2, -1, 0, 2, 3]
            Output: [0, 1, 4, 4, 9]  */
        arr = new int[]{-2, -1, 0, 2, 3};
        int[] squaredSorted = makeSquares(arr);
        //printArray(squaredSorted);
        /*------------------------------------------------------------------------------**/

//!     //Q10  find all of its distinct subsets.
        arr = new int[]{1, 2, 3};
        List<List<Integer>> subSets = findAllDistinctSubsets(arr);
        List<List<Integer>> subSets2 = findAllDistinctSubSetsRecursion(arr);
  /*      subSets2.forEach(x->{
            System.out.println(" ");
            x.forEach(System.out::print);
        });*/
        /*------------------------------------------------------------------------------**/

//!     //Q10  Order-agnostic Binary Search.
        arr = new int[]{1, 2, 3};
        int value = 3;
        int index = searchIndexByBinarySearch(arr, value);
        //System.out.println(index);
        /*------------------------------------------------------------------------------**/

        //! Bitonic Array Maximum (easy)
        /*
        Input: [1, 3, 8, 12, 4, 2]
        Output: 12
         */
        arr = new int[]{1, 3, 8, 12, 4, 2};
        int max = searchBitonicArrayMax(arr);
        //System.out.println(max);
        /*------------------------------------------------------------------------------**/

        //Pair with Target Sum (easy)
        /*
        Input: [1, 2, 3, 4, 6], target=6
         Output: [1, 3]
         */
        arr = new int[]{1, 2, 3, 4, 6};
        target = 6;
        result = findPairWithTargetSumFromSortedArray(arr, target);

        /*------------------------------------------------------------------------------**/

        //Permutations (medium)
        /*
        Input:  {1, 2, 3} ,6 permutations
         */
        arr=new int[]{1,2,3};
        List<List<Integer>> resultList=generateAllPermutationsUsingSwap(arr);
        resultList=generateAllPermutationsUsingFlags(arr);
//        resultList.forEach(x->{
//            x.forEach(System.out::print);
//            System.out.println();
//        });


        /*------------------------------------------------------------------------------**/

        //Permutations (medium)
        /*
        Input:  {1, 2, 3} ,6 permutations
         */
    }

    private static List<List<Integer>> generateAllPermutationsUsingFlags(int[] arr) {
        List<List<Integer>> result=new ArrayList<>();
        calculateAllPermutationRecursiveUsingFlags(0,arr,new ArrayList<>(),result,new boolean[arr.length]);
        return result;
    }

    private static void calculateAllPermutationRecursiveUsingFlags(int index, int[] arr, ArrayList<Integer> integers, List<List<Integer>> result, boolean[] booleans) {
        if(integers.size()==arr.length){
            result.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!booleans[i]){
                booleans[i]=true;
                integers.add(arr[i]);
                calculateAllPermutationRecursiveUsingFlags(index+1,arr,integers,result,booleans);
                integers.remove(Integer.valueOf(arr[i]));
                booleans[i]=false;
            }
        }
    }

    private static List<List<Integer>> generateAllPermutationsUsingSwap(int[] arr) {
        List<List<Integer>> result=new ArrayList<>();
        calculateAllPermutationRecursive(0,arr,result);
        return result;
    }

    private static void calculateAllPermutationRecursive(int index, int[] arr, List<List<Integer>> result) {
        if(index==arr.length){
            ArrayList<Integer> set=new ArrayList<>();
            for(int i:arr) {
                set.add(i);
            }
            result.add(set);
        }else {
            for (int i = index; i < arr.length; i++) {
                swap(i,index,arr);
                calculateAllPermutationRecursive(index + 1,  arr, result);
                swap(index,i,arr);
            }
        }
    }

    private static void swap(int i, int index, int[] arr) {
        int temp=arr[i];
        arr[i]=arr[index];
        arr[index]=temp;
    }
    private static int[] findPairWithTargetSumFromSortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int sum=arr[start]+arr[end];
            if(sum==target){
                //System.out.println("start:"+start+" end:"+end);
                return new int[]{start,end};
            } else if (target > sum) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{-1, -1};
    }


    private static int searchBitonicArrayMax(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return arr[start];
    }

    public static int searchIndexByBinarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAscending = arr[0] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (isAscending) {
                if (arr[mid] > key) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < key) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }


    private static List<List<Integer>> findAllDistinctSubsets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int i : arr) {
            int n = subsets.size();
            for (int j = 0; j < n; j++) {
                List<Integer> sets = new ArrayList<>(subsets.get(j));
                sets.add(i);
                subsets.add(sets);
            }
        }
        return subsets;
    }

    private static List<List<Integer>> findAllDistinctSubSetsRecursion(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        findDistinctSubsetResursion(0, new ArrayList<>(), arr, result);
        return result;
    }

    private static void findDistinctSubsetResursion(int index, ArrayList<Integer> subsets, int[] arr, List<List<Integer>> result) {
        result.add(new ArrayList<>(subsets));
        for (int i = index; i < arr.length; i++) {
            if (index != i && arr[i] == arr[i - 1]) {
                continue;
            }
            subsets.add(arr[i]);
            findDistinctSubsetResursion(i + 1, subsets, arr, result);
            subsets.remove(Integer.valueOf(arr[i]));
        }
    }

    private static int[] makeSquares(int[] arr) {
        int[] num = new int[arr.length];
        int highIdx = arr.length - 1;
        int leftPtr = 0, rightPtr = arr.length - 1;
        while (leftPtr <= rightPtr) {
            int leftSq = arr[leftPtr] * arr[leftPtr];
            int rightSq = arr[rightPtr] * arr[rightPtr];
            if (leftSq > rightSq) {
                num[highIdx] = leftSq;
                leftPtr++;
            } else {
                num[highIdx] = rightSq;
                rightPtr--;
            }
            highIdx--;
        }

        return num;
    }

    private static int smallestSubArraySum(int[] arr, int sum) {
        int windowStart = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while (windowSum >= sum) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


    private static int findMaxSumSubArrayWithWindow(int[] arr, int window) {
        int windowStart = 0, windowEnd = 0;
        int windowSum = 0;
        int max = Integer.MIN_VALUE;
        for (windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum = arr[windowEnd] + windowSum;
            if (windowEnd >= window - 1) {
                max = Math.max(max, windowSum);
                windowSum = windowSum - arr[windowStart];
                windowStart++;
            }
        }
        return max;
    }

    private static void cyclicSort(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int k = arr[i] - 1;
            if (arr[i] != arr[k]) {
                swap(arr, i, k);
            } else {
                i++;
            }
        }

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotValue = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i <= high && arr[i] <= pivotValue)
                i++;
            while (arr[j] > pivotValue)
                j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivotValue;
        return j;
    }

    private static List<Interval> mergeIntervals(List<Interval> matrix) {
        List<Interval> result = new ArrayList<>();
        result.add(new Interval(matrix.get(0).start, matrix.get(0).end));
        for (int i = 1; i < matrix.size(); i++) {
            Interval lastInterval = result.get(result.size() - 1);
            int currentStr = matrix.get(i).start;
            int currentEnd = matrix.get(i).end;
            int prevEnd = lastInterval.end;

            if (currentStr <= prevEnd) {
                lastInterval.end = Math.max(currentEnd, prevEnd);
            } else {
                result.add(new Interval(currentStr, currentEnd));
            }
        }
        return result;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    private static int[] stockBuySell(int[] arr) {
        int[] result = new int[2];
        int currentProfit;
        int currentBuy = arr[0];
        int globalSell = arr[1];
        int globalProfit = globalSell - currentBuy;
        int low = 1;
        while (low < arr.length) {
            currentProfit = arr[low] - currentBuy;
            if (currentProfit > globalProfit) {
                globalProfit = currentProfit;
                globalSell = arr[low];
            }
            if (arr[low] < currentBuy) {
                currentBuy = arr[low];
            }
            low++;
        }
        result[0] = globalSell - globalProfit;
        result[1] = globalSell;
        return result;
    }

    private static void moveZerosToLeft(int[] arr) {
        int len = arr.length - 1;
        int read = len;
        int write = len;
        while (read >= 0) {
            if (arr[read] != 0) {
                arr[write] = arr[read];
                write--;
            }
            read--;
        }

        while (write >= 0) {
            arr[write] = 0;
            write--;
        }
    }

    private static int findHighIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid = high / 2;
        while (low <= high) {
            if (target >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + ((high - low) / 2);
        }

        if (high == -1) {
            return high;
        }

        if (high < arr.length && arr[high] == target) {
            return high;
        }
        return -1;
    }

    private static int findMinIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid = high / 2;
        while (low <= high) {
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + ((high - low) / 2);
        }
        if (low < arr.length && arr[low] == target) {
            return low;
        }
        return -1;

    }

    private static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                return arr1[i];
            }
            if (arr2[j] >= arr1[i] && arr2[k] >= arr1[i]) {
                i++;
            } else if (arr1[i] >= arr3[k] && arr2[j] >= arr3[k]) {
                k++;
            } else if (arr1[i] >= arr2[j] && arr3[k] >= arr2[j]) {
                j++;
            }
        }
        return -1;
    }

    private static int findInRotatedArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return 0;
    }

    public static int[] SlidingWindowMaximum(int[] A, int K) {
        int n = A.length;
        if (n * K == 0) return new int[0];
        if (K == 1) return A;
        int[] right = new int[n];
        int[] left = new int[n];
        left[0] = A[0];
        right[n - 1] = A[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % K == 0)
                left[i] = A[i];
            else
                left[i] = Math.max(left[i - 1], A[i]);

            int j = n - i - 1;
            if ((j + 1) % K == 0)
                right[j] = A[j];  // block_end
            else
                right[j] = Math.max(right[j + 1], A[j]);
        }

        int[] output = new int[n - K + 1];
        for (int i = 0; i < n - K + 1; i++)
            output[i] = Math.max(left[i + K - 1], right[i]);

        return output;
    }

    private static int[] findMaxSlidingWindow(int[] arr, int window) {
        int[] result = new int[arr.length - (window - 1)];
        int i = 0;
        int max;
        int tempWndo = 0;
        while (i < arr.length - window) {
            tempWndo = 0;
            max = Integer.MIN_VALUE;
            while (tempWndo < window) {
                max = Math.max(max, arr[i + tempWndo]);
                tempWndo++;
            }
            result[i++] = max;
        }
        tempWndo = 0;
        int high = arr.length - 1;
        max = arr[high];
        while (tempWndo < window) {
            max = Math.max(max, arr[high--]);
            tempWndo++;
        }
        result[i] = max;
        return result;
    }


    private static int findEleBinarySearch(int[] arr, int target) {
        return binarySearchRec(0, arr.length - 1, arr, target);
    }

    private static int binarySearchRec(int low, int high, int[] arr, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) / 2);
        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return binarySearchRec(mid + 1, high, arr, target);
        } else {
            return binarySearchRec(low, mid - 1, arr, target);
        }
    }

    private static int findEleUsingBinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static int findMaxSumSubArray(int[] arr) {
        int currentMax = arr[0];
        int globalMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (currentMax < 0) {
                currentMax = arr[i];
            } else {
                currentMax += arr[i];
            }
            if (globalMax < currentMax) {
                globalMax = currentMax;
            }

        }
        return globalMax;
    }

    private static void reArrangeMaxMinForm(int[] arr) {
        int maxEle = arr[arr.length - 1] + 1;
        int minIdx = 0;
        int maxIdx = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = arr[i] + ((arr[maxIdx] % maxEle) * maxEle);
                maxIdx--;
            } else {
                arr[i] = arr[i] + ((arr[minIdx] % maxEle) * maxEle);
                minIdx++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxEle;
        }

    }


    private static void reArrangeInPlace(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    swap(arr, i, j);
                }
                j++;
            }
        }
    }

    private static int[] reArrange(int[] arr) {
        int[] result = new int[arr.length];
        int leftPtr = 0;
        int rightPtr = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result[leftPtr++] = arr[i];
            } else if (arr[i] < 0) {
                result[rightPtr--] = arr[i];
            }
        }
        return result;
    }

    private static void swap(int[] arr, int leftPtr, int rightPtr) {
        int temp = arr[leftPtr];
        arr[leftPtr] = arr[rightPtr];
        arr[rightPtr] = temp;
    }

    private static void rotateArray(int[] arr) {
        int temp = arr[arr.length - 1];
        System.arraycopy(arr, 0, arr, 1, arr.length - 1);
        arr[0] = temp;
    }

    private static int findSecondMaximum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j > secondMax && max != j) {
                secondMax = j;
            }
        }
        return secondMax;
    }

    private static int findFirstUnique(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int unique = 0;
        for (int j : arr) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer x = entry.getKey();
            Integer v = entry.getValue();
            if (v == 1) {
                unique = x;
            }
        }
        return unique;
    }

    private static int[] findProductOfRest(int[] arr) {
        int i = 0, j = arr.length - 1;
        int temp = 1;
        int[] result = new int[arr.length];
        while (i < arr.length) {
            result[i] = temp;
            temp = temp * arr[i];
            i++;
        }
        temp = 1;
        while (j >= 0) {
            result[j] = result[j] * temp;
            temp = temp * arr[j];
            j--;
        }
        return result;
    }

    private static int[] findSumSorted(int[] arr, int value) {
        Arrays.sort(arr);
        int low = 0, high = arr.length - 1;
        int i = 0;
        int[] summation = new int[2];
        while (i < arr.length) {
            if (arr[low] + arr[high] == value) {
                summation[0] = arr[low];
                summation[1] = arr[high];
            } else if (arr[high] > value) {
                high--;
            } else {
                low++;
            }
            i++;
        }
        return summation;
    }

    private static int[] findSum(int[] arr, int value) {
        int[] summation = new int[2];
        for (int j : arr) {
            for (int k : arr) {
                if (j + k == value) {
                    summation[0] = j;
                    summation[1] = k;
                }
            }
        }
        return summation;
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int len1 = arr1.length, a = 0;
        int len2 = arr2.length, b = 0;
        int i = 0;
        for (; i < mergedArray.length && a < len1 && b < len2; i++) {
            if (arr1[a] < arr2[b]) {
                mergedArray[i] = arr1[a];
                a++;
            } else {
                mergedArray[i] = arr2[b];
                b++;
            }
        }

        while (a < len1) {
            mergedArray[i] = arr1[a];
            i++;
            a++;
        }

        while (b < len2) {
            mergedArray[i] = arr2[b];
            i++;
            b++;
        }


        return mergedArray;
    }


    private static int[] removeEvenNumbers(int[] arr) {
        int i = 0;
        int count = 0;
        int m = 0;
        while (i < arr.length) {
            if (arr[i] % 2 != 0) {
                m++;
            }
            i++;
        }
        i = 0;
        int[] arr2 = new int[m];
        while (i < arr.length) {
            if (arr[i] % 2 != 0) {
                arr2[count] = arr[i];
                count++;
            }
            i++;
        }
        return arr2;
    }

    private static void printArray(int[] mergeArrays) {
        for (int i : mergeArrays) {
            System.out.print(i + " ");
        }
    }
}
