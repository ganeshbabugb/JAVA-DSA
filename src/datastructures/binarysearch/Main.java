package datastructures.binarysearch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        BinarySearch BS = new BinarySearch();
        int result = BS.binarySearch(ints, 100);
        System.out.println("result = " + result);
        /*
        *   For Binary Search There is an In-build function
        *   binarySearch()
        * */
        System.out.println(Arrays.binarySearch(ints, 100));
    }
}
