package Algorithm_III.Day20.problem698;

import java.util.Arrays;

public class Solution {
    int target, length;
    boolean[] used;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        length = nums.length;
        target = sum / k;
        used = new boolean[length];
        Arrays.sort(nums);
        if (preCheck(nums, sum, k)) {
            return dfs(nums, 0, 0, k);
        } else {
            return false;
        }
    }

    public boolean dfs(int[] nums, int i, int curSum, int k) {
        if (k == 0) {
            return true;
        }
        if (curSum == target) {
            return dfs(nums, 0, 0, k - 1);
        }
        for (int j = i; j < length; j++) {
            if (curSum + nums[j] > target) {
                continue;
            }
            if (used[j] || j > 0 && nums[j - 1] == nums[j] && !used[j - 1]) {
                continue;
            }
            used[j] = true;
            if (dfs(nums, j + 1, curSum + nums[j], k)) {
                return true;
            }
            used[j] = false;
        }
        return false;
    }

    public boolean preCheck(int[] nums, int sum, int k) {
        if (sum % k != 0) {
            return false;
        } else return nums[nums.length - 1] <= sum / k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
