package Algorithm_II.Day2.problem153;

public class Solution {
    public static int findMin(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            int index = (begin + end) / 2;
            if (nums[begin] > nums[index]) {
                end = index;
            } else {
                begin = index + 1;
            }
        }
        return begin;
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
