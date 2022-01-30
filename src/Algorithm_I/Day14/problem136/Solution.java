package Algorithm_I.Day14.problem136;

import java.util.Arrays;

public class Solution {
    public static int singleNumber(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        };
        if (nums[length - 2] != nums[length - 1]) {
            return nums[length - 1];
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2, 2, 1}));
    }
}
