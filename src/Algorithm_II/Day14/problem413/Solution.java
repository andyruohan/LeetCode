package Algorithm_II.Day14.problem413;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }

        int sum = 0;
        int addNumber = 0;
        int d = nums[1] - nums[0];
        for (int i = 2; i < length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                sum += ++addNumber;
            } else {
                addNumber = 0;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfArithmeticSlices(new int[] {1, 2, 3, 4}));
    }
}
