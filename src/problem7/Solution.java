package problem7;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * 解题思路：
 * 1. 通过“%10、/10”弹出每一个数，然后把上一次的结果*10+本次弹出的数
 * 2. 处理题目中提到的溢出的情况
 */
class Solution {
    public static int reverse(int x) {
        int rev = 0;
        int pop;
        while (x != 0) {
            pop = x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;
            } else if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE));
    }
}
