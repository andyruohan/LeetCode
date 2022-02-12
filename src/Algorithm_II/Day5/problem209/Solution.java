package Algorithm_II.Day5.problem209;

public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int length = nums.length;

        int sum = 0;
        int minNums = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (sum >= target) {
                right = i;
                minNums = right - left + 1;
                break;
            }
        }

        while (left < right) {
            if (right + 1 < length) {
                ++left;
                ++right;
                sum = sum + nums[right] - nums[left - 1];
            }
            while ((left < length) && (sum - nums[left] >= target)) {
                sum = sum - nums[left++];
                minNums = Math.min(minNums, minNums = right - left + 1);
            }
            if (right + 1 == length) break;
        }
        return minNums;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
        System.out.println(minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8}));
    }
}
