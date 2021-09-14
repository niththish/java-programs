package DSA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This java file contains the implementation of O(n2) sorting algorithms namely,
 * 1. Insertion sort
 * 2. Selection sort
 * 3. Bubble sort
 * 4. Optimized bubble sort
 **/

public class SortingAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        //System.out.println(Arrays.toString(insertionSort(arr)));
        //System.out.println(Arrays.toString(selectionSort(arr)));
        //System.out.println(Arrays.toString(bubbleSort(arr)));
        //System.out.println(Arrays.toString(optimizedBubbleSort(arr)));
    }

    private static int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] optimizedBubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int flag = 0;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1] > arr[j]){
                    flag = 1;
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            if(flag == 0){
                break;
            }
        }
        return arr;
    }

    private static int[] selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(key < arr[j]){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = key;
        }
        return arr;
    }

}
