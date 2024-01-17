package AdvanceDataStructure;

import java.util.Arrays;

public class SegmentTree {
    private int[] segmentTree;
    private int[] nums;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        int n = nums.length;

        // The size of the segment tree is at most 2 * n - 1
        int treeSize = 2 * (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))) - 1;
        this.segmentTree = new int[treeSize];

        buildSegmentTree(0, 0, n - 1);
    }

    private int buildSegmentTree(int index, int start, int end) {
        if (start == end) {
            segmentTree[index] = nums[start];
            return nums[start];
        }

        int mid = start + (end - start) / 2;
        segmentTree[index] = buildSegmentTree(2 * index + 1, start, mid) +
                buildSegmentTree(2 * index + 2, mid + 1, end);

        return segmentTree[index];
    }

    public int rangeSumQuery(int queryStart, int queryEnd) {
        return rangeSumQuery(0, 0, nums.length - 1, queryStart, queryEnd);
    }

    private int rangeSumQuery(int index, int start, int end, int queryStart, int queryEnd) {
        if (start > queryEnd || end < queryStart) {
            return 0;
        }

        if (queryStart <= start && queryEnd >= end) {
            return segmentTree[index];
        }

        int mid = start + (end - start) / 2;
        return rangeSumQuery(2 * index + 1, start, mid, queryStart, queryEnd) +
                rangeSumQuery(2 * index + 2, mid + 1, end, queryStart, queryEnd);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 7, 9, 11 };
        SegmentTree segmentTree = new SegmentTree(nums);

        System.out.println("Original Array: " + Arrays.toString(nums));

        int queryStart = 1;
        int queryEnd = 4;
        int sum = segmentTree.rangeSumQuery(queryStart, queryEnd);

        System.out.println("Sum of elements in the range [" + queryStart + ", " + queryEnd + "]: " + sum);
    }
}
