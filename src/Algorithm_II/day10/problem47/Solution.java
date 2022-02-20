package Algorithm_II.day10.problem47;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            if (result.toString().contains(path.toString())) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, length, depth + 1, path, used, result);
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[] {1, 1, 2}));
    }
}
