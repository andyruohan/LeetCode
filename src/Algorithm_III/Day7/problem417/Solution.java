package Algorithm_III.Day7.problem417;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int rows;
    private int cols;
    private boolean[][] flowToPacificArray;
    private boolean[][] flowToAtlanticArray;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        flowToPacificArray = new boolean[rows][cols];
        flowToAtlanticArray = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            dfsOfPacificOcean(heights, i, 0);
            dfsOfAtlanticOcean(heights, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            dfsOfPacificOcean(heights, 0, j);
            dfsOfAtlanticOcean(heights,rows - 1, j);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (flowToPacificArray[i][j] && flowToAtlanticArray[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfsOfPacificOcean(int[][] heights, int x, int y) {
        if (flowToPacificArray[x][y]) return;
        flowToPacificArray[x][y] = true;

        if (x - 1 >= 0 && heights[x][y] <= heights[x - 1][y]) {
            dfsOfPacificOcean(heights, x - 1, y);
        }
        if (x + 1 < rows && heights[x][y] <= heights[x + 1][y]) {
            dfsOfPacificOcean(heights, x + 1, y);
        }
        if (y - 1 >= 0 && heights[x][y] <= heights[x][y - 1]) {
            dfsOfPacificOcean(heights, x, y - 1);
        }
        if (y + 1 < cols && heights[x][y] <= heights[x][y + 1]) {
            dfsOfPacificOcean(heights, x, y + 1);
        }
    }

    private void dfsOfAtlanticOcean(int[][] heights, int x, int y) {
        if (flowToAtlanticArray[x][y]) return;
        flowToAtlanticArray[x][y] = true;

        if (x - 1 >= 0 && heights[x][y] <= heights[x - 1][y]) {
            dfsOfAtlanticOcean(heights, x - 1, y);
        }
        if (x + 1 < rows && heights[x][y] <= heights[x + 1][y]) {
            dfsOfAtlanticOcean(heights, x + 1, y);
        }
        if (y - 1 >= 0 && heights[x][y] <= heights[x][y - 1]) {
            dfsOfAtlanticOcean(heights, x, y - 1);
        }
        if (y + 1 < cols && heights[x][y] <= heights[x][y + 1]) {
            dfsOfAtlanticOcean(heights, x, y + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
    }
}
