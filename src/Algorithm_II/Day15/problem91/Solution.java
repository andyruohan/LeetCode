package Algorithm_II.Day15.problem91;

public class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;

        for (int i = 1; i <= length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            if (i >= 2 && s.charAt(i - 2) != '0' && 10 <= Integer.valueOf(s.substring(i - 2, i)) && Integer.valueOf(s.substring(i - 2, i)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("226"));
    }
}
