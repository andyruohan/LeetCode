package problem27;

import java.util.Arrays;

public class Solution {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == val) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            } else if (nums[right] == val) {
                right--;
            }
        }

        for (int i = 0; i <= right + 1 && right < nums.length - 1; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{2}, 3));
    }
}
