package Algorithm_III.Day3.problem287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
