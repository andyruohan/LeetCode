package Algorithm_II.Day20.problem202;

import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();

        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            n = dps(n);
        }
        return n == 1;
    }

    public int dps(int n) {
        int ans = 0;
        while (n % 10 > 0 || n / 10 > 0) {
            ans += Math.pow((n % 10), 2);
            n = n / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(2));
    }
}