package Algorithm_I.Day1.problem35;

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        return searchInsertCore(nums, 0, nums.length - 1, target);
    }

    private static int searchInsertCore(int []nums, int begin, int end, int target) {
        if (begin > end) {
            return begin;
        }
        if (begin == end) {
            if (nums[begin] >= target) {
                return begin;
            } else {
                return begin + 1;
            }
        }

        int index = (begin + end) / 2;
        if (nums[index] == target) {
            return index;
        } else if (nums[index] > target) {
            return searchInsertCore(nums, begin, index - 1, target);
        } else {
            return searchInsertCore(nums, index + 1, end, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1,3}, 0));
    }
}
