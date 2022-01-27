package Algorithm_I.Day9.problem542;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] distance = queue.poll();
            int r = distance[0];
            int c = distance[1];
            if (r - 1 >= 0 && mat[r][c] + 1 < mat[r - 1][c]) {
                mat[r - 1][c] = mat[r][c] + 1;
                queue.add(new int[]{r - 1, c});
            }
            if (r + 1 < rows && mat[r][c] + 1 < mat[r + 1][c]) {
                mat[r + 1][c] = mat[r][c] + 1;
                queue.add(new int[]{r + 1, c});
            }
            if (c - 1 >= 0 && mat[r][c] + 1 < mat[r][c - 1]) {
                mat[r][c - 1] = mat[r][c] + 1;
                queue.add(new int[]{r, c - 1});
            }
            if (c + 1 < cols && mat[r][c] + 1 < mat[r][c + 1]) {
                mat[r][c + 1] = mat[r][c] + 1;
                queue.add(new int[]{r, c + 1});
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
    }
}
