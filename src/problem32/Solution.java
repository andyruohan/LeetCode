package problem32;

import java.util.Stack;

public class Solution {
    public static int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0, currentLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && (stack.peek() == -1 || s.charAt(stack.peek()) == ')')) {
                    stack.pop();
                    stack.push(i);
                } else if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    currentLength = i - stack.peek();
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("))"));
    }
}
