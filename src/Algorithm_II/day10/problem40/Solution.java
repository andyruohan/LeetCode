package Algorithm_II.day10.problem40;

import java.util.*;

public class Solution {
    private int length;
    private int sum;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        length = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[length];
        dfs(candidates, path, result, target, used);
        return result;
    }

    public void dfs(int[] candidates, Deque<Integer> path, List<List<Integer>> result, int target, boolean[] used) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = 0; i < length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }

            if (used[i] || i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            dfs(candidates, path, result, target, used);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
