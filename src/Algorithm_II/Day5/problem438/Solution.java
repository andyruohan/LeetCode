package Algorithm_II.Day5.problem438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        if (pLength > sLength) {
            return new ArrayList<>();
        }

        int[] sStr = new int[26];
        int[] pStr = new int[26];
        for (int i = 0; i < pLength; i++) {
            ++sStr[s.charAt(i) - 'a'];
            ++pStr[p.charAt(i) - 'a'];
        }
        List<Integer> result = new ArrayList<>();
        if (Arrays.equals(sStr, pStr)) {
            result.add(0);
        }

        for (int i = 0; i < sLength - pLength; i++) {
            --sStr[s.charAt(i) - 'a'];
            ++sStr[s.charAt(i + pLength) - 'a'];
            if (Arrays.equals(sStr, pStr)) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
}
