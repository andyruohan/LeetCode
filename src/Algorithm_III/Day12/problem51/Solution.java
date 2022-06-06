package Algorithm_III.Day12.problem51;

import java.util.*;

public class Solution {
    private List<List<String>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();
        int[] queens = new int[n];
        dfs(queens, n, 0, cols, diagonal1, diagonal2);
        return solutions;
    }

    private void dfs (int[] queens, int n, int row, Set<Integer> cols, Set<Integer> diagonal1, Set<Integer> diagonal2) {
        if (n == row) {
            solutions.add(generateSolution(queens, n));
        } else {
            for (int col = 0; col < n; col++) {
                if (cols.contains(col)) {
                    continue;
                }

                int element1 = col - row;
                if (diagonal1.contains(element1)) {
                    continue;
                }

                int element2 = col + row;
                if (diagonal2.contains(element2)) {
                    continue;
                }

                queens[row] = col;
                cols.add(col);
                diagonal1.add(element1);
                diagonal2.add(element2);
                dfs(queens, n, row + 1, cols, diagonal1, diagonal2);
                diagonal2.remove(element2);
                diagonal1.remove(element1);
                cols.remove(col);
            }
        }
    }

    private List<String> generateSolution(int[] queens, int n) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            solution.add(new String(row));
        }
        return solution;
    }
}
