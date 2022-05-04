package Algorithm_III.Day7.problem417;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int rows;
    private int cols;
    boolean[][] flowToPacificArray;
    boolean[][] flowToAtlanticArray;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        flowToPacificArray = new boolean[rows][cols];
        flowToAtlanticArray = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            dfs(heights, flowToPacificArray, i, 0);
            dfs(heights, flowToAtlanticArray, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, flowToPacificArray, 0, j);
            dfs(heights,flowToAtlanticArray, rows - 1, j);
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] flowToOceanArray, int x, int y) {
        if (flowToOceanArray[x][y]) return;
        flowToOceanArray[x][y] = true;
        if (flowToPacificArray[x][y] && flowToAtlanticArray[x][y]) {
            res.add(Arrays.asList(x, y));
        }

        if (x - 1 >= 0 && heights[x][y] <= heights[x - 1][y]) {
            dfs(heights, flowToOceanArray, x - 1, y);
        }
        if (x + 1 < rows && heights[x][y] <= heights[x + 1][y]) {
            dfs(heights, flowToOceanArray, x + 1, y);
        }
        if (y - 1 >= 0 && heights[x][y] <= heights[x][y - 1]) {
            dfs(heights, flowToOceanArray, x, y - 1);
        }
        if (y + 1 < cols && heights[x][y] <= heights[x][y + 1]) {
            dfs(heights, flowToOceanArray, x, y + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
    }
}
