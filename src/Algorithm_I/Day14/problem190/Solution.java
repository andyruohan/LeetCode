package Algorithm_I.Day14.problem190;

public class Solution {
    public static int reverseBits(int n) {
        String str = Integer.toBinaryString(n);
        str = new StringBuilder(str).reverse().toString();
        return Integer.parseInt(str, 2);
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(964176192 ));
    }
}
