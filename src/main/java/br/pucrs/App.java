package br.pucrs;

import java.lang.reflect.Array;

public class App 
{
    public static void main( String[] args )
    {
        int[] arr = { 5, 2, 9, 1, 5, 6 };
        arr = MergeSort(arr);  
        for (int num : arr) {
            System.out.print(num + " "); 
        }
    }

    public static int[] MergeSort(int[] arr){
        if(arr.length == 1)
            return arr; 
        
            int n = arr.length;
 
            int[] a = new int[(n + 1)/2];
            int[] b = new int[n - a.length];
     
            for (int i = 0; i < n; i++)
            {
                if (i < a.length) {
                    a[i] = arr[i];
                }
                else {
                    b[i - a.length] = arr[i];
                }
            }
            
            a = MergeSort(a);
            b = MergeSort(b);
            int[] l = Merge(a,b);
            
            return l;
    }

    private static int[] Merge(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                merged[k++] = a[i++];
            } else {
                merged[k++] = b[j++];
            }
        }

        while (i < a.length) {
            merged[k++] = a[i++];
        }

        while (j < b.length) {
            merged[k++] = b[j++];
        }

        return merged;
    }
}
