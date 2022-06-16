package Algorithm_III.Day53.problem53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) { return nums[0]; }
        int left = 0, right = 0, curSum = nums[0], maxSum = nums[0];
        while (left < length && ++right < length) {
            curSum = nums[right] + curSum;
            if (curSum - nums[left] > curSum) {
                curSum = curSum - nums[left];
                left++;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                left = right;
                curSum = nums[left];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{1}));
        System.out.println(solution.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(solution.maxSubArray(new int[]{-1}));
        System.out.println(solution.maxSubArray(new int[]{-2, -3, -1}));
    }
}
