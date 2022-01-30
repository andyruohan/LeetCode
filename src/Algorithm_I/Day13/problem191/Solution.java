package Algorithm_I.Day13.problem191;

public class Solution {
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;

        //return Integer.bitCount(n); //复杂度为O(1)的解法
    }
}
