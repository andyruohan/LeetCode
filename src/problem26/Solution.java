package problem26;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int slowI = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[slowI] != nums[i]) {
                slowI++;
                if (slowI != i) {
                    nums[slowI] = nums[i];
                }
            }
        }
        return slowI + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
