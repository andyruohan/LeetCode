package Algorithm_III.Day12.problem51;

import java.util.List;

public class Solution {
    private boolean[][] occupiedGrid;
    private int[][] dirs = new int[][] {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public List<List<String>> solveNQueens(int n) {
        occupiedGrid = new boolean[n][n];

    }

    private void dfs (int n, int x, int y, int occupiedGridNumber, int restQueenNumber) {
        if (n * n == occupiedGridNumber + restQueenNumber) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!occupiedGrid[x][i]) {
                occupiedGrid[x][i] = true;
                occupiedGridNumber++;
            }
            if (!occupiedGrid[i][y]) {
                occupiedGrid[i][y] = true;
                occupiedGridNumber++;
            }
        }

        for (int[] dir: dirs){
            int x1 = x + dir[0];
            int y1 = y + dir[1];
            if (0 <= x1 && x1 < n && 0 <= y1 && y1 < n) {
                if (!occupiedGrid[x1][y1]) {
                    occupiedGrid[x1][y1] = true;
                    occupiedGridNumber++;
                }
            }
        }
    }
}
