package problem22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        result.add("()");
        if (n == 1) {
            return result;
        }

        for (int i = 1; i < n; i++) {
            result = generateParenthesisCore(result);
        }

        return result;
    }

    private static List<String> generateParenthesisCore(List<String> stringList) {
        List<String> curParenthesis = new ArrayList<>();
        for (String str : stringList) {
            if (!curParenthesis.contains("()"+str)) {
                curParenthesis.add("()"+str);
            }
            if (!curParenthesis.contains("("+str+")")) {
                curParenthesis.add("("+str+")");
            }
            if (!curParenthesis.contains(str+"()")) {
                curParenthesis.add(str+"()");
            }
        }
        return curParenthesis;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
