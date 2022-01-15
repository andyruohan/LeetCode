package problem704;

public class Solution {
    public static int search(int[] nums, int target) {
        return searchCore(nums, 0, nums.length - 1, target);
    }

    private static int searchCore(int []nums, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        } else if (begin == end) {
            if (nums[begin] == target) {
                return begin;
            } else {
                return -1;
            }
        }

        int index = (begin + end) / 2;
        if (nums[index] == target) {
            return index;
        } else if (nums[index] > target) {
            return searchCore(nums, begin, index - 1, target);
        } else {
            return searchCore(nums, index + 1, end, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {-1,0,3,5,9,12}, 5));
    }
}
