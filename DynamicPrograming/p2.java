package DynamicPrograming;

public class p2 {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLIS = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1; // Minimum LIS is 1

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println("Length of the Longest Increasing Subsequence: " + lengthOfLIS(nums));
    }
}
