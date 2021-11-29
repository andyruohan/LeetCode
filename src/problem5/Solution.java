package problem5;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Example 3:
 * Input: s = "a"
 * Output: "a"
 *
 * Example 4:
 * Input: s = "ac"
 * Output: "a"
 */
public class Solution {
    public static String longestPalindrome(String s) {
        int length = s.length();
        int maxSubLength;
        if (length <= 1) {
            return s;
        } else {
            maxSubLength = 1;
        }

        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int begin = 0;
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(j) != s.charAt(i)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && (j - i + 1) > maxSubLength) {
                    maxSubLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxSubLength);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }
}
