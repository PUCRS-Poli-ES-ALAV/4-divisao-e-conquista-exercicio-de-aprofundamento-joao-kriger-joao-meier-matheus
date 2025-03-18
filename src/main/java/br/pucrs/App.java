package br.pucrs;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.Random;

public class App 
{
    public static int cont;
    public static void main( String[] args )
    {
        long[] arr = generateRandomArray(1048576);

        long startTime = System.nanoTime();
        //arr = MergeSort(arr);
        long maxValue = maxVal2(arr, 0, 1048575);  

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        System.out.println("Tempo de execução: " + duration + " nanosegundos.");
        System.out.println("MaxValue: " + maxValue);
        System.out.println("Cont: " + cont);
    }

    static long maxVal1(long A[], int n) {  
        long max = A[0];
        int cont = 0;
        for (int i = 1; i < n; i++) {  
            cont += 1;
            if( A[i] > max ) 
               max = A[i];
        }
        System.out.println("Contagem de Operações: " + cont);
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

    public static long[] generateRandomArray(int n) {
        Random random = new Random();
        long[] array = new long[n];

        for (int i = 0; i < n; i++) {
            array[i] = random.nextLong(100); 
        }

        return array;
    }

    static long maxVal2(long A[], int init, int end) { 
        cont++;
        if (end - init <= 1)
            return Math.max(A[init], A[end]);  
        else {
              int m = (init + end)/2;
              long v1 = maxVal2(A,init,m);   
              long v2 = maxVal2(A,m+1,end);  
              return Math.max(v1,v2);
             }
    }
}
