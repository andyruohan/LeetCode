package Algorithm_III.Day7.problem286;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length, cols = rooms[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int round = 0;
        while (!queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] position = queue.poll();
                int x = position[0];
                int y = position[1];

                for (int[] dir : dirs) {
                    int x1 = x + dir[0];
                    int y1 = y + dir[1];
                    if (x1 >= 0 && y1 < cols && y1 >= 0 && x1 < rows && rooms[x1][y1] == Integer.MAX_VALUE) {
                        rooms[x1][y1] = round;
                        queue.add(new int[]{x1, y1});
                    }
                }
            }
        }
        System.out.println(rooms);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.wallsAndGates(new int[][]{{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}});
    }
}
