package problem7;

class Solution {
    public static int reverse(int x) {
        if (x > 0) {
            String str = String.valueOf(x);
            str = new StringBuilder(str).reverse().toString();
            return Integer.valueOf(str);
        } else if (x == 0) {
            return 0;
        } else {
            String str = String.valueOf(x);
            str = new StringBuilder(str.substring(1)).reverse().toString();
            str = "-" + str;
            return Integer.valueOf(str);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
