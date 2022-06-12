package Algorithm_III.Day14.problem301;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int[] needRemove = isValidCore(s);
        int leftNeedRemove = needRemove[0], rightNeedRemove = needRemove[1];
        dfs(s, 0, leftNeedRemove, rightNeedRemove);
        return res;
    }

    private void dfs(String str, int start, int leftNeedRemove, int rightNeedRemove) {
        if (leftNeedRemove == 0 && rightNeedRemove == 0 && isValid(str)) {
            res.add(str);
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }

            if (leftNeedRemove + rightNeedRemove > str.length()) {
                return;
            }

            if (leftNeedRemove > 0 && str.charAt(i) == '(') {
                dfs(str.substring(0, i) + str.substring(i + 1), i, leftNeedRemove - 1, rightNeedRemove);
            }

            if (rightNeedRemove > 0 && str.charAt(i) == ')') {
                dfs(str.substring(0, i) + str.substring(i + 1), i, leftNeedRemove, rightNeedRemove - 1);
            }
        }
    }

    private boolean isValid(String str) {
        int[] needRemove = isValidCore(str);
        return needRemove[0] == 0 && needRemove[1] == 0;
    }

    private int[] isValidCore(String str) {
        int leftNeedRemove = 0, rightNeedRmove = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                leftNeedRemove++;
            } else if (str.charAt(i) == ')') {
                if (leftNeedRemove == 0) {
                    rightNeedRmove++;
                } else {
                    leftNeedRemove--;
                }
            }
        }
        return new int[] {leftNeedRemove, rightNeedRmove};
    }
}
