package Algorithm_I.Day6.problem567;

public class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        int[] chars = new int[26];
        int[] charsCopy = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
        }

        int s1_charCount = 0;
        int s2_charCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                s1_charCount++;
            }
        }

        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            if (chars[s2.charAt(right) - 'a'] > 0) {
                charsCopy[s2.charAt(right) - 'a']++;
                if (chars[s2.charAt(right) - 'a'] == charsCopy[s2.charAt(right) - 'a']) {
                    s2_charCount++;
                }
            }
            right++;

            while (s1_charCount == s2_charCount) {
                if (right - left == s1.length()) {
                    return true;
                }

                if (chars[s2.charAt(left) - 'a'] > 0) {
                    charsCopy[s2.charAt(left) - 'a']--;
                    if (chars[s2.charAt(left) - 'a'] > charsCopy[s2.charAt(left) - 'a']) {
                        s2_charCount--;
                    }
                }
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "bbbca"));
    }
}
