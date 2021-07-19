package com.ly.leetcode;

/**
 * todo 溢出
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if (n > 0) {
            return x * myPow(x, n - 1);
        } else if (n < 0) {
            return (1 / x) * myPow(x, n + 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution50().myPow(2, -3));
    }
}
