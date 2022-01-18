package problem577;

public class Solution {
    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        String[] strList = s.split(" ");
        String result = "";
        for (String str1 : strList) {
            result = result + " "+ reverseString(str1);
        }
        return result.trim();
    }

    private static String reverseString(String s) {
        String reverse = "";
        for (int i = 0; i < s.length(); i++) {
            reverse = s.charAt(i) + reverse;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
