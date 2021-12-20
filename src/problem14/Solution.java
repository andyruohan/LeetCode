package problem14;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        int strNum = strs.length;
        if (strNum == 0) return "";
        if (strNum == 1) return strs[0];

        int minStrLength = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < strNum; i++) {
            int strLength = strs[i].length();
            if (strLength < minStrLength) {
                minStrLength = strLength;
                minIndex = i;
            }
        }

        int[] chars = new int[128];
        for (int j = 0; j < minStrLength; j++) {
            for (int i = 0; i < strNum; i++) {
                ++chars[strs[i].charAt(j)];
                if (i == strNum - 1) {
                    int charNum = chars[strs[0].charAt(j)]; // 每次取第1个字符串的第j个字符的个数
                    if (charNum != strNum) {
                        return strs[0].substring(0, j);
                    } else {
                        chars[strs[i].charAt(j)] = 0;
                    }
                }
            }
        }

        return strs[minIndex];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dd","dd"}));
    }
}
