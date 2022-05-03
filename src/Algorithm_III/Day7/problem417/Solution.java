package Algorithm_III.Day7.problem417;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int rows;
    private int cols;
    private int[][] flowToPacificArray;
    private int[][] flowToAtlanticArray;
    boolean[][] hasVisitedWhenPacific;
    boolean[][] hasVisitedWhenAtlantic;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        flowToPacificArray = new int[rows][cols];
        flowToAtlanticArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    flowToPacificArray[i][j] = 1;
                    continue;
                }
                hasVisitedWhenPacific = new boolean[rows][cols];
                flowToPacificArray[i][j] =  dfsOfPacificOcean(heights, i, j) ? 1: 2;
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 || j == cols - 1) {
                    flowToAtlanticArray[i][j] = 1;
                }
                hasVisitedWhenAtlantic = new boolean[rows][cols];
                flowToAtlanticArray[i][j] = dfsOfAtlanticOcean(heights, i, j) ? 1: 2;
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (flowToPacificArray[i][j] == 1 && flowToAtlanticArray[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private boolean dfsOfPacificOcean(int[][] heights, int x, int y) {
        if (!hasVisitedWhenPacific[x][y]) {
            hasVisitedWhenPacific[x][y] = true;
            if (x <= 0 || y <= 0) {
                return true;
            } else if (x > rows - 1 || y > cols - 1) {
                return false;
            } else if (flowToPacificArray[x][y] == 1) {
                return true;
            } else if (flowToPacificArray[x][y] == 2) {
                return false;
            }

            return heights[x][y] >= heights[x - 1][y] && dfsOfPacificOcean(heights, x - 1, y)
                    || x + 1 < rows && heights[x][y] >= heights[x + 1][y] && dfsOfPacificOcean(heights, x + 1, y)
                    || heights[x][y] >= heights[x][y - 1] && dfsOfPacificOcean(heights, x, y - 1)
                    || y + 1 < cols && heights[x][y] >= heights[x][y + 1] && dfsOfPacificOcean(heights, x, y + 1);
        }
        return false;
    }

    private boolean dfsOfAtlanticOcean(int[][] heights, int x, int y) {
        if (!hasVisitedWhenAtlantic[x][y]) {
            hasVisitedWhenAtlantic[x][y] = true;
            if (x >= rows - 1 || y >= cols - 1) {
                return true;
            } else if (x < 0 || y < 0) {
                return false;
            } else if (flowToAtlanticArray[x][y] == 1) {
                return true;
            } else if (flowToAtlanticArray[x][y] == 2) {
                return false;
            }

            return x - 1 >= 0 && heights[x][y] >= heights[x - 1][y] && dfsOfAtlanticOcean(heights, x - 1, y)
                    || heights[x][y] >= heights[x + 1][y] && dfsOfAtlanticOcean(heights, x + 1, y)
                    || y - 1 >= 0 && heights[x][y] >= heights[x][y - 1] && dfsOfAtlanticOcean(heights, x, y - 1)
                    || heights[x][y] >= heights[x][y + 1] && dfsOfAtlanticOcean(heights, x, y + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
    }
}
