package Algorithm_II.Day5.problem713;

public class Solution {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int length = nums.length;

        int product = 1;
        int count = 0;
        for (int i = 0; i < length; i++) {
            product *= nums[i];
            if (product < k) {
                right = i;
                count++;
                break;
            }
        }

        while (left <= right) {
            if (right + 1 < length) {
                if (nums[right + 1] < k) {
                    count++;
                }
                product *= nums[++right];
                if (product >= k) {
                    while (left < right && product / nums[left] < k) {
                        product /= nums[left++];
                        count++;
                    }
                } else {
                    count++;
                }
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(numSubarrayProductLessThanK(new int[] {10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
        System.out.println(numSubarrayProductLessThanK(new int[] {1, 1, 1}, 5));
    }
}
