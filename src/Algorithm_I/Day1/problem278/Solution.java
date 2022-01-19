package Algorithm_I.Day1.problem278;

public class Solution {
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int middle;
        while (left < right) {
            middle = ((right - left) >> 1) + left; //防止直接使用(right + left) / 2溢出
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int n) {
        if (n >= 1702766719) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }
}
