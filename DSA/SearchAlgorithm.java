package DSA;

import java.util.Scanner;

/**
 * This class contains the implementation of 3 searching algorithms namely linear,binary,exponential search
 * The binary & exponential search requires a sorted array
 * <----- Time complexity -----> 
 * Linear search -> bestCase O(1) , worstCase O(n) 
 * Binary search -> bestCase O(1) , worstCase O(logN) 
 * Exponential search -> bestCase O(1) , worstCase(log(2i))
 * Better algo:- exponential > binary > linear
 **/

public class SearchAlgorithm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        int target = sc.nextInt();

        int found = linearSearch(arr,target);
        System.out.println(found==-1?"Element not found":("Element found at index "+found));

        found = binarySearch(sorted(arr),0,arr.length-1,target);
        System.out.println(found==-1?"Element not found":("Element found at index "+found));

        found = exponentialSearch(sorted(arr),target);
        System.out.println(found==-1?"Element not found":("Element found at index "+found));

    }


    private static int linearSearch(int arr[], int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int arr[],int first,int last,int target){
        while(first<=last){
            int middle = (first + last)/2;
            if(arr[middle] < target){
                first=middle+1;
            }else if(arr[middle] > target){
                last=middle-1;
            }else{
                return middle;
            }
        }
     return -1;
    }

    private static int exponentialSearch(int arr[],int target){
        if(arr[0] == target){
            return 0;
        }
        int i = 1;
        while(i<=arr.length-1 && arr[i]<=target){
            i*=2;
        }
        return binarySearch(arr,i/2,Math.min(i,arr.length-1),target);
    }


    private static int[] sorted(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
