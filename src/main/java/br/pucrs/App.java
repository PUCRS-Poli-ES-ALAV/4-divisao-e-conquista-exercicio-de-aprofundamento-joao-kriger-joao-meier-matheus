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
        //long maxValue = maxVal2(arr, 0, 1048575);  

        //long multiplier4bit = multiply(15, 10, 4);
        //long multiplier16bit = multiply(32767, 16384, 16);
        long multiplier64bit = multiply(9223372036854775807L, 123456789L, 64);


        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        System.out.println("Tempo de execução: " + duration + " nanosegundos.");
        //System.out.println("Multiplier 4 bits: " + multiplier4bit);
        //System.out.println("Multiplier 16 bits: " + multiplier16bit);
        System.out.println("Multiplier 64 bits: " + multiplier64bit);
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

    private static long maxVal2(long A[], int init, int end) { 
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

    private static long multiply(long x, long y, long n){
        cont++;
        if (n == 1) return x * y;
        else{
            int m = (int) Math.ceil(n / 2.0);
            long a = x / (long) (Math.pow(2,m));
            long b = x % (long) (Math.pow(2,m));
            long c = y / (long) (Math.pow(2,m));
            long d = y % (long) (Math.pow(2,m));

            long e = multiply(a, c, m);
            long f = multiply(b, d, m);
            long g = multiply(b, c, m);
            long h = multiply(a, d, m);

            return (long) (Math.pow(2, 2*m) * e) + (long) (Math.pow(2,m) * (g + h) + f);
        }
    }

    private static long multiplyString(String X, String Y) {
        int n = Math.max(X.length(), Y.length());
        
        return multiplyRecursive(X, Y, n);
    }

    private static long multiplyRecursive(String X, String Y, int n) {
        cont++;  

        if (n == 1) {
            return X.charAt(0) == '1' && Y.charAt(0) == '1' ? 1 : 0;
        } else {
            int m = (int) Math.ceil(n / 2.0);

            String X1 = X.substring(0, m); 
            String X2 = X.substring(m);    
            String Y1 = Y.substring(0, m); 
            String Y2 = Y.substring(m);    

            long e = multiplyRecursive(X1, Y1, m);
            long f = multiplyRecursive(X2, Y2, m);
            long g = multiplyRecursive(X2, Y1, m);
            long h = multiplyRecursive(X1, Y2, m);

            return (long) (Math.pow(2, 2 * m) * e + Math.pow(2, m) * (g + h) + f);
        }
    }
}
