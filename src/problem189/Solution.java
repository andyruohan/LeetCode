package problem189;

public class Solution {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int offset = n - k, temp;

        for (int i = 0; i < k; i++) {
            temp = nums[i];
            nums[i] = nums[i + offset];
            nums[i + offset] = temp;
        }

        for (int i = k; i < n; i++) {
            temp = nums[i];
            nums[i] = nums[--n];
            nums[n] = temp;
        }
        return;
    }

    public static void main(String[] args) {
        rotate(new int[] {1,2,3,4,5,6,7}, 3);
    }
}
