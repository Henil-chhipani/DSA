package Sorting;

public class p6 {
    public static void heapSort(int[] array) {
        int length = array.length;

        // Build a max heap
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // Extract elements from the heap one by one
        for (int i = length - 1; i >= 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Heapify the reduced heap
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // Compare with left child
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // Compare with right child
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // If the largest is not the root, swap and heapify the affected subtree
        if (largest != rootIndex) {
            int swap = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = swap;

            heapify(array, heapSize, largest);
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

        heapSort(array);

        System.out.println("Sorted Array using Heap Sort:");
        printArray(array);
    }
}
