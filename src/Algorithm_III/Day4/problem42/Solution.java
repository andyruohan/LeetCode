package Algorithm_III.Day4.problem42;

public class Solution {
    private int length;
    public int trap(int[] height) {
        int ans = 0; length = height.length;
        for (int i = 0; i < length; i++) {
            ans += Math.min(max(height, 0, i), max(height,i, length - 1)) - height[i];
        }
        return ans;
    }

    private int max(int[] height, int left, int right) {
        int max = 0;
        for (int i = left; i <= right; i++) {
            if (max < height[i]) {
                max = height[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
