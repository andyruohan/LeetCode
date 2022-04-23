package Algorithm_III.Day6.problem239;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private int length;
    public int[] maxSlidingWindow(int[] nums, int k) {
        length = nums.length;
        int left = 0, right = k - 1, maxIndex = findMaxIndex(nums, left, right);
        Map<Character, Integer> alphabetMap = new HashMap();
        List<Integer> result = new ArrayList<>();
        while (right < length) {
            if (left <= maxIndex && maxIndex <= right) {
                if (nums[right] > nums[maxIndex]) {
                    maxIndex = right;
                }
                result.add(nums[maxIndex]);
            } else {
                maxIndex = findMaxIndex(nums, left, right);
                result.add(nums[maxIndex]);
            }
            left++;
            right++;
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int findMaxIndex(int[] height, int left, int right) {
        int max = -10001, maxIndex = 0;
        for (int i = left; i <= right; i++) {
            if (max < height[i]) {
                max = height[i];
                maxIndex = i;
            } else if (max == height[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        System.out.println(solution.maxSlidingWindow(new int[]{1, -1}, 1));
//        System.out.println(solution.maxSlidingWindow(new int[]{7, 2, 4}, 2));
    }
}
