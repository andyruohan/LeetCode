package Algorithm_II.Day8.problem1091;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        queue.add(new int[] {0, 0});
        grid[0][0] = 1;
        int path = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int [] curPosition = queue.poll();
                int x = curPosition[0];
                int y = curPosition[1];

                if (x == m - 1 && y == n - 1) {
                    return path;
                }

                for (int [] nextDir: dir) {
                    int x1 = x + nextDir[0];
                    int y1 = y + nextDir[1];
                    if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] == 1) {
                        continue;
                    }

                    queue.add(new int[]{x1, y1});
                    grid[x1][y1] = 1;
                }
            }
            path++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
    }
}
