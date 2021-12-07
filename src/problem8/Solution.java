package problem8;

public class Solution {
    public static int myAtoi(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        Integer left = null;
        Integer right = null;
        Boolean alreadyHasDigt = false;
        Character signFlag = null;
        for (int i = 0; i < length; i++) {
            if (' ' != s.charAt(i)) {
                if ((s.charAt(i) == '-' || s.charAt(i) == '+') && i != length - 1 && left == null) {
                    signFlag = s.charAt(i);
                    continue;
                }
                if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    //处理"00000-42a1234"这样的前排为0的字符串
                    if (alreadyHasDigt) {
                        return 0;
                    }

                    //处理"  0000000000012345678"这样的前排为0的字符串
                    if (s.charAt(i) == '0' && left == null) {
                        continue;
                    } else if (s.charAt(i) == '0' && signFlag != null) {
                        continue;
                    }
                    if (left == null) {
                        left = i;
                    } else {
                        right = i;
                    }
                } else {
                    if (left == null) {
                        return 0;
                    } else if (left != null && right != null) {
                        alreadyHasDigt = true;
                    } else {
                        return 0;
                    }
                }
                if (i == length -1) {
                    right = i;
                }
            } else {
                if (left != null) {
                    break;
                }
            }
        }


        if (left != null && length == 1) {
            return Integer.valueOf(s);
        } else if (left == null) {
            return 0;
        }
        String str = s.substring(left, right + 1);
        if (signFlag != null) {
            str = signFlag + str;
        }

        //处理"20000000000000000000"这样的超长字符串
        if (str.length() > 15) {
            str = str.substring(0, 16);
        }

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
        System.out.println(myAtoi("-91283472332"));
    }
}
