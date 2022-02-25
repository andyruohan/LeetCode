package Algorithm_II.Day12.problem55;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > i - j || nums[j] == i - j && i == nums.length - 1) {
                        break;
                    } else if (j == 0) {
                        return false;
                    }
                }
            }
        }
        return count != nums.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.canJump(new int[]{2, 3, 1, 0, 4}));
//        System.out.println(solution.canJump(new int[]{0}));
//        System.out.println(solution.canJump(new int[]{0, 1}));
//        System.out.println(solution.canJump(new int[]{2, 0, 0}));
//        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(solution.canJump(new int[]{1, 1, 1, 0}));
    }
}
