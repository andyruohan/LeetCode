package Algorithm_III.Day6.problem76;

import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        int length_s = s.length(), length_t = t.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0, right = 0, minLength = 10001;
        HashMap<Integer, Integer[]> result = new HashMap<>();

        int[] array = new int[128];
        for (int i = 0; i < length_t; i++) {
            array[t.charAt(i)]++;
        }

        while (right < length_s) {
            if (array[s.charAt(right)] != 0) {
                hashMap.put(s.charAt(right), right);
            }
            if (hashMap.size() == length_t) {
                left = Collections.min(hashMap.values());
                minLength = Math.min(minLength, right - left + 1);
                hashMap.remove(s.charAt(left));
                result.put(minLength, new Integer[]{left, right});
            }
            right++;
        }


        if (minLength != 10001) {
            Integer[] pointers = result.get(minLength);
            return s.substring(pointers[0], pointers[1] + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(solution.minWindow("a", "a"));
//        System.out.println(solution.minWindow("a", "aa"));
//        System.out.println(solution.minWindow("ab", "a"));
        System.out.println(solution.minWindow("aa", "aa"));
    }
}
