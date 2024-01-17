package DynamicPrograming;

public class p3 {
    public static int countWays(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // There is one way to make change for zero amount (using no coins)

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;

        int ways = countWays(coins, amount);

        System.out.println("Number of ways to make change for " + amount + " cents: " + ways);
    }
}
