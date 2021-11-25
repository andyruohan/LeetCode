package problem3;

/**
 * 解题思路：
 * 1. 通过滑动right指针遍历字符串，已遍历的字符放进ASCII数组并计数
 * 2. 某个字符数量大于1时滑动left指针，直至滑动到该字符数不大于1为止
 * 3. 取滑动过程中，right-left+1的最大值即为返回结果
 *
 * 优化：
 * 1. 记录right指针的下标，而非累加计数
 * 2. left指针直接滑动到上一次字符出现的位置，不必逐步滑
 */
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Integer[] chars = new Integer[128];
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            char r = s.charAt(right);

            Integer index = chars[r];
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }

            res = Math.max(res, right - left + 1);
            chars[r] = right;
            right++;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("abcabcbb"));
    }
}
