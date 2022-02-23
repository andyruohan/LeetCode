package Algorithm_II.Day10.problem47;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[length];
        dfs(nums, length, 0, path, used, result);
        return result;
    }

    public static void dfs(int[] nums, int length, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (depth == length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, length, depth + 1, path, used, result);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[] {1, 1, 2}));
    }
}
