package Algorithm_III.Day20.problem416;

import java.util.*;

public class Solution {
    int sum, curSum;
    Set<Integer> ignoreIndex = new HashSet<>();
    Map<String, Boolean> visitedMap = new HashMap<>();
    boolean result;
    public boolean canPartition(int[] nums) {
        sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        if (preCheck(nums, sum)) {
            dfs(nums, 0, 0);
        }
        return result;
    }

    public boolean dfs(int[] nums, int i, int depth) {
        curSum += nums[i];
        if (2 * curSum == sum) {
            result = true;
            visitedMap.put(Integer.toString(curSum) + "_" + depth + "_" + i, result);
            return result;
        } else if (2 * curSum > sum) {
            curSum -= nums[i];
        } else {
            String key = Integer.toString(curSum) + "_" + depth + "_" + i;
            ignoreIndex.add(i);
            for (int j = 0; j < nums.length && !result; j++) {
                if (!ignoreIndex.contains(j)) {
                    if(visitedMap.containsKey(key)) {
                        result = visitedMap.get(key);
                        return result;
                    }

                    boolean temp = dfs(nums, j, depth + 1);
                    visitedMap.put(Integer.toString(curSum) + "_" + depth + "_" + i, temp);
                }
            }
            ignoreIndex.remove(i);
            curSum -= nums[i];

        }
        return false;
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
//        System.out.println(solution.canPartition(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100}));
        System.out.println(solution.canPartition(new int[]{18,17,18,11,15,4,13,11,9}));
    }
}
