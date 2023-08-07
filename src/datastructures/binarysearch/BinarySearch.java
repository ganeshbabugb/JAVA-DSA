package datastructures.binarysearch;

public class BinarySearch {
    public int binarySearch(int[] ints, int target) {
        int length = ints.length;
        int low = 0;
        int high = length - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (ints[mid] == target) {
                return mid;
            } else if (target < ints[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
