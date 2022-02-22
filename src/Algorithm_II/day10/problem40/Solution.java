package Algorithm_II.day10.problem40;

import java.util.*;

public class Solution {
    private int length;
    private int sum;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        length = candidates.length;
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>(set);
        if (length == 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[length];
        dfs(candidates, path, set, target, used);
        return new ArrayList<>(set);
    }

    public void dfs(int[] candidates, Deque<Integer> path, Set<List<Integer>> result, int target, boolean[] used) {
        if (sum == target) {
            List<Integer> pathList = new ArrayList<>(path);
            Collections.sort(pathList);
            result.add(pathList);
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
