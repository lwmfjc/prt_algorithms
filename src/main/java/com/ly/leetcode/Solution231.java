package com.ly.leetcode;

public class Solution231 {
    /**
     * n>=2
     *
     * @param n
     * @return
     */
    public boolean judge(int n) {
        if (n == 2) {
            return true;
        } else if (n == 0) {
            return false;
        }
        if (n % 2 == 1) {
            return false;
        } else {
            return isPowerOfTwo(n / 2);
        }

    }

    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        } else {
            return judge(n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution231().isPowerOfTwo(
                1
        ));
    }
}
