package problem16;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 */
public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int length = nums.length;
        int best = 100000;
        for (int i = 0; i < length - 1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1; int high = length - 1;
                while (low < high) {
                    int value = nums[low] + nums[high] + nums[i];
                    if (value == target) {
                        return target;
                    }
                    if (Math.abs(best - target) > Math.abs(value - target)) {
                        best = value;
                    }
                    if (value > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-3,-2,-5,3,-4}, -1));
    }
}
