package com.ly.leetcode;
//遇到比较大的值没法处理
public class Solution67 {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return climbStairs(n - 2) + climbStairs(n - 1);
    }

    public static void main(String[] args) {
        int result = new Solution67().climbStairs(30);
        System.out.println(result);
    }
}
