package Algorithm_II.Day6.problem6.problem200;

public class Solution {
    public static int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int numOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ++numOfIslands;
                    dfs(grid, i, j);
                }
            }
        }

        return numOfIslands;
    }

    public static void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }

        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
    }
}
