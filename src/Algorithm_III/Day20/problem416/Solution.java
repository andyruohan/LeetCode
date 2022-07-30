package Algorithm_III.Day20.problem416;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    int sum, curSum;
    Set<Integer> ignoreIndex = new HashSet<>();
    boolean result;
    public boolean canPartition(int[] nums) {
        sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        dfs(nums, 0);
        return result;
    }

    public boolean dfs(int[] nums, int i) {
        curSum += nums[i];
        if (2 * curSum == sum) {
            result = true;
        } else if (2 * curSum > sum) {
            curSum -= nums[i];
        } else {
            ignoreIndex.add(i);
            for (int j = 0; j < nums.length && !result; j++) {
                if (!ignoreIndex.contains(j)) {
                    dfs(nums, j);
                }
            }
            ignoreIndex.remove(i);
            curSum -= nums[i];
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.canPartition(new int[]{2, 2, 1, 1}));
//        System.out.println(solution.canPartition(new int[]{9,1,2,4,10}));
        System.out.println(solution.canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
    }
}
