package Algorithm_I.Day14.problem190;

public class Solution {
    public int reverseBits(int n) {
        int reverseN = 0;
        for (int i = 0; i < 32; i++) {
            reverseN += (1 & (n >> i)) << (31 - i);
        }
        return reverseN;

        //return Integer.reverse(n); //JDK源码
    }
}
