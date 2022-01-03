package problem22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add(""); 
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesis(i)) {
                    for (String right : generateParenthesis(n - 1 - i)) {
                        result.add("(" + left + ")" + right);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
}
