package Algorithm_III.Day5.problem159;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int length = s.length();
        if (length <= 2) return length;
        int left = 0, right = 0, res = 0;

        Map<Character, Integer> alphabetMap = new HashMap();
        while (right < length) {
            char currentChar = s.charAt(right);
            if (!alphabetMap.containsKey(currentChar)) {
                if (alphabetMap.size() < 2) {
                    alphabetMap.put(currentChar, right);
                } else if (alphabetMap.size() == 2) {
                    int min = Integer.MAX_VALUE;
                    for (Integer value: alphabetMap.values()) {
                        if (min > value) {
                            min = value;
                        }
                    }
                    left = min + 1;
                    alphabetMap.remove(s.charAt(min));
                    alphabetMap.put(currentChar, right);
                }
            } else {
                alphabetMap.put(currentChar, right);
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
//        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("a"));
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("aac"));
    }
}
