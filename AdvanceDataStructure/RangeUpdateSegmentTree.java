package AdvanceDataStructure;

import java.util.Arrays;

public class RangeUpdateSegmentTree {
    private int[] segmentTree;
    private int[] lazy;
    private int[] nums;

    public RangeUpdateSegmentTree(int[] nums) {
        this.nums = nums;
        int n = nums.length;

        // The size of the segment tree is at most 2 * n - 1
        int treeSize = 2 * (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))) - 1;
        this.segmentTree = new int[treeSize];
        this.lazy = new int[treeSize];

        buildSegmentTree(0, 0, n - 1);
    }

    private void buildSegmentTree(int index, int start, int end) {
        if (start == end) {
            segmentTree[index] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;
        buildSegmentTree(2 * index + 1, start, mid);
        buildSegmentTree(2 * index + 2, mid + 1, end);

        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }

    public void rangeUpdate(int updateStart, int updateEnd, int value) {
        rangeUpdate(0, 0, nums.length - 1, updateStart, updateEnd, value);
    }

    private void rangeUpdate(int index, int start, int end, int updateStart, int updateEnd, int value) {
        // Update lazy value for current node
        if (lazy[index] != 0) {
            segmentTree[index] += (end - start + 1) * lazy[index];

            // Propagate the lazy update to children
            if (start != end) {
                lazy[2 * index + 1] += lazy[index];
                lazy[2 * index + 2] += lazy[index];
            }

            // Reset lazy update for current node
            lazy[index] = 0;
        }

        // No overlap
        if (start > updateEnd || end < updateStart) {
            return;
        }

        // Complete overlap
        if (updateStart <= start && updateEnd >= end) {
            segmentTree[index] += (end - start + 1) * value;

            // Propagate the lazy update to children
            if (start != end) {
                lazy[2 * index + 1] += value;
                lazy[2 * index + 2] += value;
            }

            return;
        }

        // Partial overlap, update both children
        int mid = start + (end - start) / 2;
        rangeUpdate(2 * index + 1, start, mid, updateStart, updateEnd, value);
        rangeUpdate(2 * index + 2, mid + 1, end, updateStart, updateEnd, value);

        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }

    public int rangeQuery(int queryStart, int queryEnd) {
        return rangeQuery(0, 0, nums.length - 1, queryStart, queryEnd);
    }

    private int rangeQuery(int index, int start, int end, int queryStart, int queryEnd) {
        // Update lazy value for current node
        if (lazy[index] != 0) {
            segmentTree[index] += (end - start + 1) * lazy[index];

            // Propagate the lazy update to children
            if (start != end) {
                lazy[2 * index + 1] += lazy[index];
                lazy[2 * index + 2] += lazy[index];
            }

            // Reset lazy update for current node
            lazy[index] = 0;
        }

        // No overlap
        if (start > queryEnd || end < queryStart) {
            return 0;
        }

        // Complete overlap
        if (queryStart <= start && queryEnd >= end) {
            return segmentTree[index];
        }

        // Partial overlap, query both children
        int mid = start + (end - start) / 2;
        int leftSum = rangeQuery(2 * index + 1, start, mid, queryStart, queryEnd);
        int rightSum = rangeQuery(2 * index + 2, mid + 1, end, queryStart, queryEnd);

        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 7, 9, 11 };
        RangeUpdateSegmentTree segmentTree = new RangeUpdateSegmentTree(nums);

        System.out.println("Original Array: " + Arrays.toString(nums));

        int updateStart = 1;
        int updateEnd = 4;
        int updateValue = 2;
        segmentTree.rangeUpdate(updateStart, updateEnd, updateValue);

        System.out
                .println("Array after range update [" + updateStart + ", " + updateEnd + "] by " + updateValue + ": " +
                        Arrays.toString(nums));

        int queryStart = 1;
        int queryEnd = 4;
        int sum = segmentTree.rangeQuery(queryStart, queryEnd);

        System.out.println("Sum of elements in the range [" + queryStart + ", " + queryEnd + "]: " + sum);
    }
}
