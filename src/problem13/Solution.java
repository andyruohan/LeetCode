package problem13;

import java.util.HashMap;

public class Solution {
    public static int romanToInt(String s) {
        HashMap<String, Integer> symbolAndValue1 = new HashMap<>();
        HashMap<String, Integer> symbolAndValue2 = new HashMap<>();
//        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
//        int[] value = {1, 5, 10, 50, 100, 500, 1000};
//        symbolAndValue.put(symbol, value);
        symbolAndValue1.put("I", 1);
        symbolAndValue1.put("V", 5);
        symbolAndValue1.put("X", 10);
        symbolAndValue1.put("L", 50);
        symbolAndValue1.put("C", 100);
        symbolAndValue1.put("D", 500);
        symbolAndValue1.put("M", 1000);

        symbolAndValue2.put("IV", 4);
        symbolAndValue2.put("IX", 9);
        symbolAndValue2.put("XL", 40);
        symbolAndValue2.put("XC", 90);
        symbolAndValue2.put("CD", 400);
        symbolAndValue2.put("CM", 900);

        int result = 0;
        for (String str: symbolAndValue2.keySet()) {
            while (s.contains(str)) {
                String temp;
                result = result + symbolAndValue2.get(str);
                temp = s.replaceFirst(str, "");
                s = temp;
            }
        }

        for (String str: symbolAndValue1.keySet()) {
            while (s.contains(str)) {
                String temp;
                result = result + symbolAndValue1.get(str);
                temp = s.replaceFirst(str, "");
                s = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }
}
