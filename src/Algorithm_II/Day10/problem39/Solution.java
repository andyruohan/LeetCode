package Algorithm_II.Day10.problem39;

import java.util.*;

public class Solution {
    private int length;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        length = candidates.length;
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>(set);
        if (length == 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, path, set, target);
        return new ArrayList<>(set);
    }

    public void dfs(int[] candidates, int sum, Deque<Integer> path, Set<List<Integer>> result, int target) {
        if (sum == target) {
            List<Integer> pathList = new ArrayList<>(path);
            Collections.sort(pathList);
            result.add(pathList);
            return;
        }

        for (int i = 0; i < length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.addLast(candidates[i]);
            sum += candidates[i];
            dfs(candidates, sum, path, result, target);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
