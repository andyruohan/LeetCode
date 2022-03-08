package Algorithm_II.Day17.problem583;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length(), dp[][] = new int[m + 1][n + 1];
        dp[0][0] = 0; dp[0][1] = 0; dp[1][0] = 0;

        for (int i = 0; i < m; i++) {
            char charI = word1.charAt(i);
            for (int j = 0; j < n; j++) {
                if (charI == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return m + n - 2 * dp[m][n];
    }
}
