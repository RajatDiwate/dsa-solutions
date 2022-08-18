package ProblemSolving.array.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

        //Q9 10: Rearrange Sorted Array in Max/Min Form
        //arr = {1, 2, 3, 4, 5}==>arr = {5, 1, 4, 2, 3}
        arr = new int[]{1, 2, 3, 4, 5};
        //If 'i' is even
        //arr[i] += arr[max_index] % max_element * max_element
        //max_index--
        //ELSE // if 'i' is odd
        //arr[i] +=  arr[min_index] % max_element * max_element
        //min_index++
    }

    private static void maxMin(int[] arr){

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
