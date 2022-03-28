package Algorithm_III.Day1.problem1060;

public class Solution {
    public int missingElement(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) return nums[0] + k;

        for (int i = 1; i < length; i++) {
            if (missingNbr(nums, i - 1) < k && k <= missingNbr(nums, i)) {
                return nums[i - 1] + k - missingNbr(nums, i - 1);
            } else if (k > missingNbr(nums, i) && i == length - 1) {
                return nums[i] + k - missingNbr(nums, i);
            }
        }
        return -1;
    }

    private int missingNbr(int[] nums, int i) {
        return nums[i] - (nums[0] + i);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.missingElement(new int[]{4, 7, 9, 10}, 2));
//        System.out.println(solution.missingElement(new int[]{4, 7, 9, 10}, 3));
//        System.out.println(solution.missingElement(new int[]{1, 2, 4}, 3));
        System.out.println(solution.missingElement(new int[]{1}, 1));
    }
}
