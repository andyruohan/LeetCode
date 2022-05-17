package Algorithm_III.Day10.problem1368;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int[] distance = new int[m * n];
        boolean[] hasVisited = new boolean[m * n];

        distance[0] = 0;
        Deque<Integer> queue = new LinkedList();
        queue.add(0);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (hasVisited[index]) {
                continue;
            }
            hasVisited[index] = true;

            int x = index / n;
            int y = index % n;
            for (int i = 0; i < 4; i++) {
                int x0 = x + directions[i][0];
                int y0 = y + directions[i][1];
                int newIndex = x0 * n + y0;
                int newDistance = distance[index] + (grid[x][y] == i + 1 ? 0: 1);

                if (x0 < 0 || x0 >= m || y0 < 0 || y0 >= n) {
                    continue;
                } else {
                    distance[newIndex] = newDistance;
                    if (grid[x][y] == i + 1) {
                        queue.addFirst(newIndex);
                    } else {
                        queue.addLast(newIndex);
                    }
                }
            }
        }
        return distance[m * n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCost(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}}));
//        System.out.println(solution.minCost(new int[][]{{1, 1, 3}, {3, 2, 2}, {1, 1, 4}}));
    }
}
