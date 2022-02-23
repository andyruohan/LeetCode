package Algorithm_II.Day10.problem40;

import java.util.*;

public class Solution {
    private int length;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, path, result, target - candidates[i], i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
