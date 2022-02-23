package Algorithm_II.Day10.problem39;

import java.util.*;

public class Solution {
    private int length;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        length = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length == 0) return result;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, path, result, target, 0);
        return result;
    }

    public void dfs(int[] candidates, Deque<Integer> path, List<List<Integer>> result, int target, int idx) {
        if (0 == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < length; i++) {
            if (candidates[i] > target) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, path, result, target - candidates[i], i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
