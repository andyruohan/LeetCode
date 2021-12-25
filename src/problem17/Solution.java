package problem17;

import java.util.*;

public class Solution {
    static List<String> numberMap = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

    public static List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            result = combination(result, digits.charAt(i) - '0');
        }
        return result;
    }

    private static List<String> combination(List<String> curList, int nextDgt) {
        List<String> combResult = new ArrayList<>();
        for (String s : curList) {
            for (int j = 0; j < numberMap.get(nextDgt).length(); j++) {
                combResult.add(s + numberMap.get(nextDgt).charAt(j));
            }
        }
        return combResult;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }
}


