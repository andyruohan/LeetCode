package Algorithm_III.Day6.problem1004;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int length = nums.length, left = 0, right = 0, ans = 0;
        Deque<Integer> deque = new LinkedList<>();
        while (right < length) {
            if (nums[right] == 0) {
                deque.addLast(right);
            }
            if (deque.size() > k) {
                left = deque.getFirst() + 1;
                deque.removeFirst();
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}
