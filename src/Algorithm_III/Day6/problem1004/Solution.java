package Algorithm_III.Day6.problem1004;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, zeroNum = 0, ans = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroNum++;
            }
            while (zeroNum > k) {
                if (nums[left] == 0) {
                    zeroNum--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}
