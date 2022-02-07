package Algorithm_II.Day2.problem153;

public class Solution {
    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int begin = 0;
        int end = nums.length - 1;
        int minValue = Integer.MAX_VALUE;
        int index = 0;
        while (begin <= end) {
            index = (begin + end) / 2;
            if (nums[begin] > nums[index]) {
                minValue = Math.min(minValue, nums[index]);
                end = index - 1;
            } else if (nums[index] > nums[end]) {
                minValue = Math.min(minValue, nums[begin]);
                begin = index + 1;
            } else if (nums[begin] <= nums[index] && nums[index] <= nums[end]) {
                minValue = Math.min(minValue, nums[begin]);
                break;
            }
        }
        return minValue;
    }

//    public static int findMinCore(int[] nums, int begin, int end) {
//        int index = (begin + end) / 2;
//        if (nums[begin] > nums[index]) {
//            return Math.min(nums[index], findMinCore(nums, begin, index - 1));
//        } else if (nums[index] > nums[end]) {
//            return Math.min(nums[begin], findMinCore(nums, index + 1, end));
//        }
//    }

    public static void main(String[] args) {
//        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
//        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{2, 1}));
    }
}
