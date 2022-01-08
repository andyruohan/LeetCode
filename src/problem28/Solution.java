package problem28;

public class Solution {
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
//        System.out.println("mississippi".indexOf("issipi"));
    }
}
