package Sorting;

public class p4 {
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Already sorted or empty
        }

        int length = array.length;
        int[] tempArray = new int[length];

        mergeSort(array, tempArray, 0, length - 1);
    }

    private static void mergeSort(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort the left and right halves
            mergeSort(array, tempArray, left, mid);
            mergeSort(array, tempArray, mid + 1, right);

            // Merge the sorted halves
            merge(array, tempArray, left, mid, right);
        }
    }

    private static void merge(int[] array, int[] tempArray, int left, int mid, int right) {
        // Copy data to temporary arrays
        System.arraycopy(array, left, tempArray, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int k = left;

        // Merge the two sorted arrays
        while (i <= mid && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of left subarray
        while (i <= mid) {
            array[k] = tempArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of right subarray
        while (j <= right) {
            array[k] = tempArray[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 5, 3, 7, 2, 8, 4, 1 };

        System.out.println("Original Array:");
        printArray(array);

        mergeSort(array);

        System.out.println("Sorted Array using Merge Sort:");
        printArray(array);
    }
}
