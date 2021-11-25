package problem3;

/**
 * 解题思路：
 * 1. 通过滑动right指针遍历字符串，已遍历的字符放进ASCII数组并计数
 * 2. 某个字符数量大于1时滑动left指针，直至滑动到该字符数不大于1为止
 * 3. 取滑动过程中，right-left+1的最大值即为返回结果
 */
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("pwwkew"));
    }
}
