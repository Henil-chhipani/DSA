package Searching;

import java.util.Arrays;

public class p5 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Check if the right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] rotatedArray = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        int result = search(rotatedArray, target);

        System.out.println("Array: " + Arrays.toString(rotatedArray));
        System.out.println("Target Element: " + target);
        System.out.println("Index of Target Element: " + result);

    }
}
