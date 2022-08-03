package Algorithm_III.Day20.problem416;

import java.util.*;

public class Solution {
    int sum, length;
    Map<String, Boolean> visitedMap = new HashMap<>();
    public boolean canPartition(int[] nums) {
        length = nums.length;
        sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        if (preCheck(nums, sum)) {
            return dfs(nums, 0, sum);
        } else {
            return false;
        }
    }

    public boolean dfs(int[] nums, int i, int target) {
        String key = target + "_" + i;
        if (target == sum / 2) {
            return true;
        }
        if (visitedMap.containsKey(key)) {
            return visitedMap.get(key);
        }
        if (i >= length) {
            return false;
        }
        visitedMap.put(key, dfs(nums, i + 1, target - nums[i]) || dfs(nums, i + 1, target));
        return visitedMap.get(key);
    }

    public boolean preCheck(int[] nums, int sum) {
        if (sum % 2 == 1) {
            return false;
        } else return nums[nums.length - 1] <= sum / 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.canPartition(new int[]{2, 2, 1, 1}));
//        System.out.println(solution.canPartition(new int[]{9,1,2,4,10}));
//        System.out.println(solution.canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
//        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100}));
        System.out.println(solution.canPartition(new int[]{18,17,18,11,15,4,13,11,9}));
    }
}
