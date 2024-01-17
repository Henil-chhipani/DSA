package DynamicPrograming;

public class p5 {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] represents the minimum edit distance between word1[0...i-1] and
        // word2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Initialization
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // Minimum edits to convert an empty string to word2[0...j-1]
                } else if (j == 0) {
                    dp[i][j] = i; // Minimum edits to convert word1[0...i-1] to an empty string
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No edit needed, same character
                } else {
                    // Take the minimum of insert, delete, and replace operations
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "kitten";
        String word2 = "sitting";

        int distance = minDistance(word1, word2);

        System.out.println("Edit Distance between '" + word1 + "' and '" + word2 + "': " + distance);
    }
}
