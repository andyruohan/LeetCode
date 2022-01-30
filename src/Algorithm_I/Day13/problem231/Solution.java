package Algorithm_I.Day13.problem231;

public class Solution {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }

        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1024));
    }
}
