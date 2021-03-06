package Algorithm_II.Day3.problem15;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 */
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < length - 1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1; int high = length - 1; int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        resultList.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {low++;}
                        while (low < high && nums[high] == nums[high - 1]) {high--;}
                        low++; high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2,0,0,2,2}));
    }
}
