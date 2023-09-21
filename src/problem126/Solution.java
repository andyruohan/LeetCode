package problem126;

/**
 * @author andy_ruohan
 * @description 斐波那契数列
 * @date 2023/9/21 23:19
 */
class Solution {

//    public int fib(int n) {
//        if (n < 1) {
//            throw new IllegalArgumentException(n + "不能小于1");
//        }
//        if (n == 1 || n == 2) {
//            return n;
//        }
//        return (fib(n - 1) + fib(n - 2)) % 1000000007;
//    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int one = 0;
        int two = 1;
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = (one + two) % 1000000007;
            one = two;
            two = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fib(48));
    }
}
