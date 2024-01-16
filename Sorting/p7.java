package Sorting;

// countingSort
public class p7 {
    public static void countingSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Already sorted
        }

        // Find the maximum value in the array
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // Create a counting array to store the count of each element
        int[] countArray = new int[max + 1];

        // Count the occurrences of each element
        for (int value : array) {
            countArray[value]++;
        }

        // Modify the counting array to store the position of each element in the sorted
        // order
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Create a temporary array to store the sorted result
        int[] sortedArray = new int[array.length];

        // Build the sorted array
        for (int i = array.length - 1; i >= 0; i--) {
            int value = array[i];
            int index = countArray[value] - 1;
            sortedArray[index] = value;
            countArray[value]--;
        }

        // Copy the sorted array back to the original array
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 4, 2, 2, 8, 3, 3, 1 };

        System.out.println("Original Array:");
        printArray(array);

        countingSort(array);

        System.out.println("Sorted Array using Counting Sort:");
        printArray(array);
    }
}
