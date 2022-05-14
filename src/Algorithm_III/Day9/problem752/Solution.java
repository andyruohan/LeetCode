package Algorithm_III.Day9.problem752;

import java.util.*;

public class Solution {
    HashSet<String> deadSet = new HashSet<>();
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Collections.addAll(deadSet, deadends);
        if (deadSet.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList();
        queue.add("0000");
        HashSet<String> hasVisited = new HashSet<>();
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
        char[] unVisitedArray = str.toCharArray();
        for (int i = 0; i < 4; i++) {
            char temp = unVisitedArray[i];
            unVisitedArray[i] = getPreNum(temp);
            statusNums.add(new String(unVisitedArray));
            unVisitedArray[i] = getNextNum(temp);
            statusNums.add(new String(unVisitedArray));
            unVisitedArray[i] = temp;
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
//        System.out.println(solution.openLock(new String[] {"0000"}, "8888"));
        System.out.println(solution.openLock(new String[] {"5557","5553","5575","5535","5755","5355","7555","3555","6655","6455","4655","4455","5665","5445","5645","5465","5566","5544","5564","5546","6565","4545","6545","4565","5656","5454","5654","5456","6556","4554","4556","6554"}, "5555"));
    }
}
