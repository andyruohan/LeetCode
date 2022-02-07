package Algorithm_II.Day2.problem162;

public class Solution {
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            int index = (begin + end) / 2;
            if (nums[index] > nums[index + 1]) {
                end = index;
            } else {
                begin = index + 1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1,2,1,3,5,6,4}));
    }
}
