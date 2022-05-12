package Algorithm_III.Day9.problem752;

import java.util.*;

public class Solution {
    HashSet<String> deadSet = new HashSet<>();
    public int openLock(String[] deadends, String target) {
        if (Arrays.asList(deadends).contains("0000")) {
            return -1;
        } else if ("0000".equals(target)) {
            return 0;
        }

        for (String deadend: deadends) {
            deadSet.add(deadend);
        }

        Queue<String> queue = new ArrayDeque();
        queue.add("0000");
        List<String> hasVisited = new ArrayList<>();
        hasVisited.add("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String str = queue.poll();
                for (String curNum: getNextStatusNums(str)) {
                    if (!deadSet.contains(curNum) && !hasVisited.contains(curNum)) {
                        if (curNum.equals(target)) {
                            return step;
                        }
                        hasVisited.add(curNum);
                        queue.add(curNum);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNextStatusNums(String str) {
        List<String> statusNums = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] unVisitedArray = str.toCharArray();
            char temp = unVisitedArray[i];
            unVisitedArray[i] = getPreNum(temp);
            statusNums.add(new String(unVisitedArray));
            unVisitedArray[i] = getNextNum(temp);
            statusNums.add(new String(unVisitedArray));
        }
        return statusNums;
    }

    private char getPreNum(char c) {
        return c == '0' ? '9' : (char)(c - 1);
    }

    private char getNextNum(char c) {
        return c == '9' ? '0' : (char)(c + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
        System.out.println(solution.openLock(new String[] {"0000"}, "8888"));
    }
}
