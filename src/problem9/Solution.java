package problem9;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            String str = String.valueOf(x);
            boolean oddFlag = str.length() % 2 > 0;
            for (int i = 0; i < (str.length() + 1) / 2; i++) {
                if (oddFlag && i == (str.length() + 1) / 2) {
                    return true;
                }
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1233211));
    }
}
