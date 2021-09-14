package DSA;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr){
        int n = arr.length;
        if(n<2){
            return;
        }
        int mid = n/2;
        int left[] = new int[mid];
        int right[] = new int[n-mid];

        for(int i=0;i<mid;i++){
            left[i] = arr[i];
        }

        for(int j=mid;j<n;j++){
            right[j-mid] = arr[j];
        }

        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);
    }

    private static void merge(int[] left,int[] right,int[] arr){
        int leftLen = left.length;
        int rightLen = right.length;
        int i = 0, j = 0, k = 0;

        while(i<leftLen && j<rightLen){
            if(left[i] < right[j]){
                arr[k] = left[i];
                i++; k++;
            }else{
                arr[k] = right[j];
                j++; k++;
            }
        }

        while (i<leftLen){
            arr[k] = left[i];
            i++; k++;
        }

        while (j<rightLen){
            arr[k] = right[j];
            j++; k++;
        }

    }
}
