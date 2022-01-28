package Algorithm_I.Day11.problem784;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        int length = s.length();
        StringBuilder path = new StringBuilder();
        dfs(s, length, 0, path, res);
        return res;
    }

    private static void dfs(String s, int length, int depth, StringBuilder path, List<String> res) {
        if (path.length() == length) {
            res.add(path.toString());
            return;
        }

        for (int i = depth; i < length; i++) {
            char c = s.charAt(i);
            path.append(c);
            dfs(s, length, depth + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        letterCasePermutation("a1b2");
    }
}
