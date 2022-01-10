package problem34;

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int rightIndex = searchRangeCore(nums, 0, nums.length - 1, target, false) - 1;
        int leftIndex = searchRangeCore(nums, 0, nums.length - 1, target, true);
        if (leftIndex <= rightIndex && rightIndex <= nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[] {leftIndex, rightIndex};
        } else {
            return new int[] {-1, -1};
        }
    }

    private static int searchRangeCore(int []nums, int begin, int end, int target, boolean lower) {
        if (begin > end) {
            return begin;
        }

        int index = (begin + end) / 2;
        if (lower && nums[index] >= target || nums[index] > target) {
            return searchRangeCore(nums, begin, index - 1, target, lower);
        } else {
            return searchRangeCore(nums, index + 1, end, target, lower);
        }
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{5,7,7,8,8,10}, 8));
    }
}
