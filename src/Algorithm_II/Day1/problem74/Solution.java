package Algorithm_II.Day1.problem74;

public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int begin = 0;
        int end = m - 1;
        int rowIndex = 0;
        while (begin <= end) { // 此处不加等号，对matrix = [[1],[3]]，target = 3，处理不佳
            int index = (begin + end) / 2;
            if (matrix[index][0] > target) {
                end = index - 1;
                rowIndex = end;
            } else if (matrix[index][0] == target) {
                return true;
            } else {
                begin = index + 1;
                rowIndex = index;
            }
        }

        if (rowIndex < 0 || rowIndex > m-1) {
            return false;
        }

        int left = 0;
        int right = n - 1;
        int colIndex= 0;
        while (left < right) { // 此处加不加等号，效果一致
            int index = (left + right) / 2;
            if (matrix[rowIndex][index] > target) {
                right = index - 1;
                colIndex = right;
            } else if (matrix[rowIndex][index] == target) {
                return true;
            } else {
                left = index + 1;
                colIndex = left;
            }
        }

        if (0 <= colIndex && colIndex <= n-1) {
            return matrix[rowIndex][colIndex] == target;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 60));
//        System.out.println(searchMatrix(new int[][] {{1, 1}}, 0));
//        System.out.println(searchMatrix(new int[][] {{1, 1}, {2, 2}}, 0));
//        System.out.println(searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 11));
//        System.out.println(searchMatrix(new int[][] {{1,3}}, 3));
        System.out.println(searchMatrix(new int[][] {{1}, {3}}, 3));
    }
}
