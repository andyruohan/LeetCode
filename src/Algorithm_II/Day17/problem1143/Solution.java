package Algorithm_II.Day17.problem1143;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length(), dp[][] = new int[m + 1][n + 1];
        dp[0][0] = 0; dp[0][1] = 0; dp[1][0] = 0;

        for (int i = 0; i < m; i++) {
            char charI = text1.charAt(i);
            for (int j = 0; j < n; j++) {
                if (charI == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }
}
