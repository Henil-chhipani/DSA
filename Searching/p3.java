package Searching;

import java.util.Arrays;

public class p3 {
    public static int findFirstOccurrence(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int firstOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                firstOccurrence = mid;
                right = mid - 1; // Continue searching in the left subarray
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstOccurrence;
    }

    public static int findLastOccurrence(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int lastOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                lastOccurrence = mid;
                left = mid + 1; // Continue searching in the right subarray
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastOccurrence;
    }

    public static void main(String[] args) {
        int[] sortedArray = { 1, 2, 2, 3, 3, 3, 4, 5, 5, 6 };
        int target = 2;

        int firstOccurrence = findFirstOccurrence(sortedArray, target);
        int lastOccurrence = findLastOccurrence(sortedArray, target);

        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Target Element: " + target);
        System.out.println("First Occurrence: " + firstOccurrence);
        System.out.println("Last Occurrence: " + lastOccurrence);
    }
}
