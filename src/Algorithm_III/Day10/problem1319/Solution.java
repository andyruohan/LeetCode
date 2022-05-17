package Algorithm_III.Day10.problem1319;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer>[] edges;
    boolean[] hasVisited;
    public int makeConnected(int n, int[][] connections) {
        int length = connections.length;
        if (length < n - 1) {
            return -1;
        }

        edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int [] connection: connections) {
            edges[connection[0]].add(connection[1]);
            edges[connection[1]].add(connection[0]);
        }

        hasVisited = new boolean[n];
        int isolatedNode = 0;
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(i);
                ++isolatedNode;
            }
        }
        return isolatedNode - 1;
    }

    private void dfs(int curNode) {
        hasVisited[curNode] = true;
        for (Integer node: edges[curNode]) {
            if (!hasVisited[node]) {
                dfs(node);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println(solution.makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}}));

    }
}
