package problem278;

public class Solution {
    public static int firstBadVersion(int n) {
        if (n == 0) {
            return 0;
        }

        int left = 1;
        int right = n;
        int middle, ans = n;
        while (left <= right) {
            if (left == right && isBadVersion(left)) {
                return left;
            }
            middle = ((right - left) >> 1) + left; //防止直接使用(right + left) / 2溢出
            if (isBadVersion(middle)) {
                ans = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return ans;
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
