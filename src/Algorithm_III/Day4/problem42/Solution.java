package Algorithm_III.Day4.problem42;

public class Solution {
    private int length;
    public int trap(int[] height) {
        int ans = 0; length = height.length;
        if (length == 1) return 0;

        int leftMax = height[0];
        int maxIndex = findMaxIndex(height);
        int rightMax = height[maxIndex];
        int i, j;
        for (i = 0; i < length; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
            ans += Math.min(leftMax, rightMax) - height[i];
            if (i + 1 > maxIndex) {
                break;
            }
        }
        rightMax = height[length - 1];
        for (j = length - 1; j > i; j--) {
            if (height[j] > rightMax) {
                rightMax = height[j];
            }
            ans += Math.min(leftMax, rightMax) - height[j];
        }
        return ans;
    }

    private int findMaxIndex(int[] height) {
        int max = 0, maxIndex = 0;
        for (int i = 0; i <= length - 1; i++) {
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
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        System.out.println(solution.trap(new int[]{4, 2, 3}));

    }
}
