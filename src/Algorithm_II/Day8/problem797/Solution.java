package Algorithm_II.Day8.problem797;

import java.util.*;

public class Solution {
    static List<List<Integer>> result = new ArrayList<>();
    static Deque<Integer> stack = new ArrayDeque<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length);
        return result;
    }

    private static void dfs(int[][] graph, int i, int length) {
        if (i == length - 1) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int j : graph[i]) {
            stack.offerLast(j);
            dfs(graph, j, length);
            stack.pollLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }
}
