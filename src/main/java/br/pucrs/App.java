package br.pucrs;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.Random;

public class App 
{
    public static void main( String[] args )
    {
        int[] arr = generateRandomArray(1048576);
        
        long startTime = System.nanoTime();
        arr = MergeSort(arr);  

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        System.out.println("Tempo de execução: " + duration + " nanosegundos.");
    }

    long maxVal1(long A[], int n) {  
        long max = A[0];
        for (int i = 1; i < n; i++) {  
            if( A[i] > max ) 
               max = A[i];
        }
        return max;
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

    public static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100); 
        }

        return array;
    }
}
