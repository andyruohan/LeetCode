package Algorithm_II.Day6.problem574;

public class Solution {
    public static int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        int circleNum = 0;
        boolean[] hasVisited = new boolean[length];

        for (int i = 0; i < length; i++) {
            if (!hasVisited[i]) {
                dfs(isConnected, i, length, hasVisited);
                ++circleNum;
            }
        }

        return circleNum;
    }

    private static void dfs(int[][] isConnected, int i, int length, boolean[] hasVisited) {
        for (int j = 0; j < length; j++) {
            if (isConnected[i][j] == 1 && !hasVisited[j]) {
                hasVisited[j] = true;
                dfs(isConnected, j, length, hasVisited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(findCircleNum(new int[][] {{1,0,0},{0,1,0},{0,0,1}}));
        System.out.println(findCircleNum(new int[][] {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }
}
