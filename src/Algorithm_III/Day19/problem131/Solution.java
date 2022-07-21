package Algorithm_III.Day19.problem131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int n;
    private List<List<String>> resList = new ArrayList<List<String>>();
    private List<String> res = new ArrayList<String>();
    private boolean[][] dp;

    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        dfs(s, 0);
        return resList;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            resList.add(new ArrayList<>(res));
        }

        for (int j = i; j < n; j++) {
            if (dp[i][j]) {
                res.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                res.remove(res.size() - 1);
            }
        }
    }
}
