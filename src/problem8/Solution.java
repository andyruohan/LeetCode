package problem8;

public class Solution {
    public static int myAtoi(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        Integer left = null;
        Integer right = null;
        for (int i = 0; i < length; i++) {
            if (' ' != s.charAt(i)) {
                if ((s.charAt(i) == '-' || s.charAt(i) == '+') && i != length - 1 && left == null) {
                    left = i;
                    continue;
                }
                if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    if (left == null) {
                        left = i;
                    } else {
                        right = i;
                    }
                } else {
                    if (left == null) {
                        return 0;
                    } else if (left != null && right != null) {
                        break;
                    } else if (left != null && (s.charAt(left) == '-' || s.charAt(left) == '+')) {
                        return 0;
                    } else if (left != null && (s.charAt(left) != '-' && s.charAt(left) != '+')) {
                        return Integer.valueOf(s.substring(left, left + 1));
                    }
                }
            }
        }


        if (left != null && length == 1) {
            return Integer.valueOf(s);
        } else if (left == null) {
            return 0;
        }
        String str = s.substring(left, right + 1);
        Long num = Long.valueOf(str);
        if (Integer.MIN_VALUE <= num && num <= Integer.MAX_VALUE) {
            return Integer.valueOf(str);
        } else if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("1"));
    }
}
