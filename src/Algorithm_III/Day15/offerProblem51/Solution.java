package Algorithm_III.Day15.offerProblem51;

import java.util.Arrays;

public class Solution {
    private int length;

    public int reversePairs(int[] nums) {
        length = nums.length;
        if (length < 2) {
            return 0;
        }

        int[] copy = Arrays.copyOf(nums, length);
        return reversePairsCore(nums, copy, 0, length - 1);
    }

    public int reversePairsCore(int[] nums, int[] copy, int left, int right) {
        if (left == right) {
            copy[left] = nums[left];
            return 0;
        }

        int mid = (left + right) >> 1;
        int leftPairs = reversePairsCore(nums, copy, left, mid);
        int rightPairs = reversePairsCore(nums, copy, mid + 1, right);
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        } else {
            return leftPairs + rightPairs + merge(nums, copy, left, mid, right);
        }
    }

    public int merge(int[] nums, int[] copy, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            copy[i] = nums[i];
        }

        int i = left, j = mid + 1, count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = copy[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = copy[i];
                count += (right - mid);
                i++;
            } else if (copy[i] <= copy[j]) {
                nums[k] = copy[i];
                count += (j - 1) - (mid + 1) + 1;
                i++;
            } else {
                nums[k] = copy[j];
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }
}
