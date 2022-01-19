package Algorithm_I.Day2.problem189;

public class Solution {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(n, k);

        for (int i = 0; i < count; i++) {
            int cur = i;
            int curValue = nums[cur];
            do {
                int next = (cur + k) % n;
                int nextValue = nums[next];
                nums[next] = curValue;
                curValue = nextValue;
                cur = next;
            } while (cur != i);
        }
        System.out.println("123");
    }

    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
