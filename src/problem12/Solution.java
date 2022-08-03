package problem12;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 */

public class Solution {
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if (num > 0) {
            if (num / 1000 > 0) {
                if (num / 1000 < 4) {
//                    sb.append("M".repeat(num / 1000));
                }
                num = num % 1000;
            }
            if (num / 100 > 0) {
                if (num / 100 < 4) {
//                    sb.append("C".repeat(num / 100));
                } else if (num / 100 == 4) {
                    sb.append("CD");
                } else if (num / 100 < 9) {
                    sb.append("D");
//                    sb.append("C".repeat(num / 100 - 5));
                } else if (num / 100 == 9) {
                    sb.append("CM");
                }
                num = num % 100;
            }
            if (num / 10 > 0) {
                if (num / 10 < 4) {
//                    sb.append("X".repeat(num / 10));
                } else if (num / 10 == 4) {
                    sb.append("XL");
                } else if (num / 10 < 9) {
                    sb.append("L");
//                    sb.append("X".repeat(num / 10 - 5));
                } else if (num / 10 == 9) {
                    sb.append("XC");
                }
                num = num % 10;
            }
            if (num > 0) {
                if (num < 4) {
//                    sb.append("I".repeat(num));
                } else if (num == 4) {
                    sb.append("IV");
                } else if (num  < 9) {
                    sb.append("V");
//                    sb.append("I".repeat(num  - 5));
                } else if (num == 9) {
                    sb.append("IX");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(140));
    }
}
