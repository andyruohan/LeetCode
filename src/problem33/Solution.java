package problem33;

public class Solution {
    public static int search(int[] nums, int target) {
        if (nums[0] <= target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                } else if (nums[i] > target) {
                    return -1;
                }
            }
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    return i;
                } else if (nums[i] < target) {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
