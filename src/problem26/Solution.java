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
                    int temp = nums[i];
                    nums[i] = nums[slowI];
                    nums[slowI] = temp;
                }
            }
        }
        return slowI + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
