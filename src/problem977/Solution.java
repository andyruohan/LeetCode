package problem977;

import java.util.Arrays;

public class Solution {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];
        int left = 0, right = n - 1, index = n - 1;
        int leftSquareValue, rightSquareValue;
        while (left <= right) {
            leftSquareValue = nums[left] * nums[left];
            rightSquareValue = nums[right] * nums[right];
            if (leftSquareValue <= rightSquareValue) {
                result[index--] = rightSquareValue;
                right--;
            } else {
                result[index--] = leftSquareValue;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
