package Algorithm_I.Day11.problem784;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> letterCasePermutation(String s) {
        List<StringBuilder> copy = new ArrayList<>();
        copy.add(new StringBuilder());

        for (Character c : s.toCharArray()) {
            int n = copy.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; i++) {
                    copy.add(new StringBuilder(copy.get(i)));
                    copy.get(i).append(Character.toLowerCase(c));
                    copy.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    copy.get(i).append(c);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (StringBuilder sb : copy) {
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        letterCasePermutation("a1b2");
    }
}
