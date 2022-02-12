package Algorithm_II.Day5.problem713;

public class Solution {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int product = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k) product = product / nums[left++];
            result += i - left + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
        System.out.println(numSubarrayProductLessThanK(new int[] {1, 1, 1}, 5));
        System.out.println(numSubarrayProductLessThanK(new int[] {10,2,2,5,4,4,4,3,7,7}, 289));

    }
}
