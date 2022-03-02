package Algorithm_II.Day15.problem139;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
//        System.out.println(solution.wordBreak("catsanddog", wordDict));
//        wordDict.add("aaaa");
//        wordDict.add("aaa");
//        System.out.println(solution.wordBreak("aaaaaaa", wordDict));
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(solution.wordBreak("applepenapple", wordDict));
    }
}
