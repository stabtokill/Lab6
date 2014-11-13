package WrittingToDocs;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Names: Zimmer, Hoffman, Silewski 
 * Group name: The Best of The Class 
 * Section# 2
 * Lab Exercise #6
 */
public class WriteTestMain {

    private static int[] unsorted_Array = new int[50000];
    private static int[] sorted_Array = new int[50000];
    private static int[] keys_Array = new int[100];
    private static int size = 100;
    private static long estimatedTime = 0;

    //generates random values for the Array
    public static void generate() {
        for (int i = 0; i < unsorted_Array.length; i++) {
            unsorted_Array[i] = (int) (Math.random() * 100000);
            sorted_Array[i] = unsorted_Array[i];
        }
    }

    //finds random values in the array and saves them in keys_Array
    public static void keyMaker() {
        int temp;
        for (int i = 0; i < keys_Array.length; i++) {
            temp = (int) (Math.random() * 50000);
            keys_Array[i] = unsorted_Array[temp];
        }
    }

    public static int seqSearch(int[] a, int b) {
        /*
         searches using sequential search and records time it took to find it.
         */
        long startTime = System.nanoTime();
        for (int i = 0; i < a.length; i++) {
            if (b == a[i]) {
                estimatedTime = System.nanoTime() - startTime;
                return i;
                //record i  index position
            }
        }
        return -1;
    }

    public static int binSearch(int[] a, int b) {
        /*
         searches using binary search and records time it took to find it if it does find it.
         */
        long startTime = System.nanoTime();
        if (a.length == 0) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (b > a[mid]) {
                low = mid + 1;
            } else if (b < a[mid]) {
                high = mid - 1;
            } else {
                estimatedTime = System.nanoTime() - startTime;
                //record mid  index position
                return mid;
            }
        }
        estimatedTime = System.nanoTime() - startTime;
        return -1; // if it doesn't find it.
    }

    //returns run time
    public static long getTime() {
        return estimatedTime;
    }

    public static void main(String[] args) {

        /*
         * sets up other classes and then generates random values
         * then sorts, keys, 
         */
        WriteToWord w = new WriteToWord(size);
        Quicksort qsort = new Quicksort();
        generate();
        qsort.qSort(sorted_Array, 0, sorted_Array.length - 1);
        keyMaker();

        for (int i = 0; i < keys_Array.length; i++) {
            w.addTo(i, 0, keys_Array[i]);
            w.addTo(i, 1, seqSearch(unsorted_Array, keys_Array[i]));
            w.addTo(i, 2, getTime());
            w.addTo(i, 3, seqSearch(sorted_Array, keys_Array[i]));
            w.addTo(i, 4, getTime());
            w.addTo(i, 5, binSearch(unsorted_Array, keys_Array[i]));
            w.addTo(i, 6, getTime());
            w.addTo(i, 7, binSearch(sorted_Array, keys_Array[i]));
            w.addTo(i, 8, getTime());
            /*
             arrays that are sent to the sequential or binary search to search for
             the values in the arrays.
             */
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(unsorted_Array[i] + "\t" + unsorted_Array[49899 + i]
                    + "\t" + sorted_Array[i] + "\t" + sorted_Array[49899 + i]);
        }
        /* 
         prints out the first 100 and last 100 values of our unsorted array.   
         */

        try {
            w.WriteToMs();
        } catch (IOException ex) {
            Logger.getLogger(WriteTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
