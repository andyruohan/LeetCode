package Algorithm_I.Day4.problem344;

public class Solution {
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
    }
}
