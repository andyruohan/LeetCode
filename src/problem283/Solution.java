package problem283;

public class Solution {
    public static void moveZeroes(int[] nums) {
        int nonZeroNums = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                while (i + 1 < n && nums[i + 1] == 0) {
                    i++;
                }
            } else {
                nums[nonZeroNums] = nums[i];
                nonZeroNums++;
            }
        }


        for (int j = nonZeroNums; j < n; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
