package Algorithm_II.Day15.problem139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int count = 0;
        Set<String> words = new HashSet<>();
        for (String str : wordDict) {
            if (s.contains(str)) {
                ++count;
                words.add(str);
            }
        }

        return count == words.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(solution.wordBreak("leetcode", wordDict));
    }
}
