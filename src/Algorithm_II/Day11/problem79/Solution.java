package Algorithm_II.Day11.problem79;

public class Solution {
    private boolean existFlag;
    private int rows, cols, stringLength;
    private int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        stringLength = word.length();
        char[] letters = word.toCharArray();

        char startChar = word.charAt(0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == startChar) {
                    dfs(board, letters, i, j, 0);
                }
            }
        }

        return existFlag;
    }

    public void dfs(char[][] board, char[] letters, int x, int y, int index) {
        if (index >= stringLength) {
            return;
        }

        if (board[x][y] == letters[index]) {
            if (index == stringLength - 1) {
                existFlag = true;
                return;
            }

            for (int[] dir : dirs) {
                int x1 = x + dir[0];
                int y1 = y + dir[1];
                if (x1 < 0 || x1 >= rows || y1 < 0 || y1 >= cols || board[x1][y1] == '*') {
                    continue;
                }
                char temp = board[x][y];
                board[x][y] = '*';
                dfs(board, letters, x1, y1, index + 1);
                board[x][y] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
//        System.out.println(solution.exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB"));
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }
}
