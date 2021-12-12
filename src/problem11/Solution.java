package problem11;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 */
public class Solution {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int area = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                area = Math.max(area, height[left] * (right - left));
                left++;
            } else {
                area = Math.max(area, height[right] * (right - left));
                right--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[] height = {1, 2, 1};
        System.out.println(maxArea(height));
    }
}
