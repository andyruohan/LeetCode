package Algorithm_III.Day1.problem1901;

public class Solution {
    private int m;
    private int n;

    public int[] findPeakGrid(int[][] mat) {
        m = mat.length;
        n = mat[0].length;


        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int middle = (left + right) / 2, middleLeftMaxIndex, middleLeftMaxValue, middleMaxIndex, middleMaxValue, middleRightMaxIndex, middleRightMaxValue;
            if (middle == 0) {
                middleLeftMaxValue = -1;
            } else {
                middleLeftMaxIndex = getMaxIndexOfColumn(mat, middle - 1);
                middleLeftMaxValue = mat[middleLeftMaxIndex][middle - 1];
            }

            middleMaxIndex = getMaxIndexOfColumn(mat, middle);
            middleMaxValue = mat[middleMaxIndex][middle];


            if (middle == n - 1) {
                middleRightMaxValue = -1;
            } else {
                middleRightMaxIndex = getMaxIndexOfColumn(mat, middle + 1);
                middleRightMaxValue = mat[middleRightMaxIndex][middle + 1];
            }

            int maxValue = Math.max(Math.max(middleLeftMaxValue, middleMaxValue), middleRightMaxValue);
            if (maxValue == middleMaxValue) {
                return new int[]{middleMaxIndex, middle};
            } else if (maxValue == middleLeftMaxValue) {
                right = middle - 1;
            } else if (maxValue == middleRightMaxValue) {
                left = middle + 1;
            }
        }

        return new int[] {-1, -1};
    }

    public int getMaxIndexOfColumn(int[][] mat, int j) {
        int maxValue = 0, maxIndex = 0;
        int i;
        for (i = 0; i < m; i++) {
            maxValue = Math.max(maxValue, mat[i][j]);
            if (mat[i][j] == maxValue) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findPeakGrid(new int[][]{{1, 4}, {3, 2}}));
        System.out.println(solution.findPeakGrid(new int[][]{{47,30,35,8,25},{6,36,19,41,40},{24,37,13,46,5},{3,43,15,50,19},{6,15,7,25,18}}));
    }
}
