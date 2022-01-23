package Algorithm_I.Day7.problem733;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color == newColor) {
            return image;
        }
        dfs(image, sr, sc, color, newColor);
        return image;
    }

    public void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (image[x][y] == color) {
            image[x][y] = newColor;
            int rows = image.length;
            int cols = image[0].length;
            if (x >= 1) dfs(image, x - 1, y, color, newColor);
            if (x + 1 < rows) dfs(image, x + 1, y, color, newColor);
            if (y >= 1) dfs(image, x, y-1, color, newColor);
            if (y + 1 < cols) dfs(image, x, y+1, color, newColor);
        }
    }
}
