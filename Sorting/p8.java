package Sorting;

import java.util.Arrays;

public class p8 {
    public static void radixSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Already sorted or empty
        }

        // Find the maximum number to know the number of digits
        int max = Arrays.stream(array).max().getAsInt();
        int exp = 1;

        // Do counting sort for every digit
        while (max / exp > 0) {
            countingSort(array, exp);
            exp *= 10;
        }
    }

    private static void countingSort(int[] array, int exp) {
        int length = array.length;
        int[] output = new int[length];
        int[] count = new int[10];

        // Count occurrences of each digit
        for (int i = 0; i < length; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Modify count array to store actual position of this digit in output
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to the original array
        System.arraycopy(output, 0, array, 0, length);
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 170, 45, 75, 90, 802, 24, 2, 66 };

        System.out.println("Original Array:");
        printArray(array);

        radixSort(array);

        System.out.println("Sorted Array using Radix Sort:");
        printArray(array);
    }
}
