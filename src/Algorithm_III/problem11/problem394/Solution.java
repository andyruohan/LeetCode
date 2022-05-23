package Algorithm_III.problem11.problem394;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<Character>();
        int leftSquareBracketNum = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // 非编码字段直接计入结果
            if (stack.isEmpty() && 'a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                res.append(s.charAt(i));
                continue;
            }

            // 编码字段处理
            char temp = s.charAt(i);
            if (temp == ']') {
                // 取[]中的字母
                StringBuilder curStringBuilder = new StringBuilder();
                while (stack.peek() != '[') {
                    curStringBuilder.insert(0, stack.peek());
                    stack.pop();
                }

                // 弹出左括号
                stack.pop();
                leftSquareBracketNum--;

                // 取[前的数字
                StringBuilder curNumberBuilder = new StringBuilder();
                while (!stack.isEmpty() && '0'<= stack.peek() && stack.peek() <= '9') {
                    curNumberBuilder.insert(0, stack.peek());
                    stack.pop();
                }

                // 局部解码
                String curString = curStringBuilder.toString();
                String curNumber = curNumberBuilder.toString();
                StringBuilder curDecodeStringBuilder = new StringBuilder();
                for (int j = 0; j < Integer.parseInt(curNumber); j++) {
                    curDecodeStringBuilder.insert(0, curString);
                }

                // 计入结果
                String curDecodeString = curDecodeStringBuilder.toString();
                if (i == s.length() - 1) {
                    return res + curDecodeString;
                } else if (leftSquareBracketNum == 0) {
                    res.append(curDecodeString);
                } else { // 如果栈中还有左括号，将解码数据重新放入栈中
                    for (int j = 0; j < curDecodeString.length(); j++) {
                        stack.push(curDecodeString.charAt(j));
                    }
                }
                continue;
            }

            stack.push(temp);
            if (temp == '[') {
                leftSquareBracketNum++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.decodeString("3[a]2[bc]"));
//        System.out.println(solution.decodeString("3[a2[c]]"));
//        System.out.println(solution.decodeString("abc3[cd]xyz"));
        System.out.println(solution.decodeString("100[leetcode]"));
    }
}
