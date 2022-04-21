package Algorithm_III.Day5.problem340;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int length = s.length();
        int left = 0, right = 0, res = 0;

        Map<Character, Integer> alphabetMap = new HashMap();
        while (right < length) {
            char currentChar = s.charAt(right);
            alphabetMap.put(currentChar, right);
            if (alphabetMap.size() >= k + 1) {
                int min = Collections.min(alphabetMap.values());
                left = min + 1;
                alphabetMap.remove(s.charAt(min));
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("eceba", 2));
//        System.out.println(solution.lengthOfLongestSubstringKDistinct("aa", 1));

    }
}
