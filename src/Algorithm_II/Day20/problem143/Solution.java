package Algorithm_II.Day20.problem143;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 1, curMax = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> hashMap = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int a = points[i][0] - points[j][0];
                int b = points[i][1] - points[j][1];
                int k = gcd(a, b);
                String key = (a / k) + "_" + (b / k);
                hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
                curMax = Math.max(curMax, hashMap.get(key));
            }
            ans = Math.max(ans, curMax + 1);
        }

        return ans;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxPoints(new int[][] {{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}}));
        System.out.println(solution.maxPoints(new int[][] {{0,0}}));
    }
}
