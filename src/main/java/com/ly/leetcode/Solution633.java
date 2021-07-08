package com.ly.leetcode;

public class Solution633 {
    public static boolean judgeSquareSum(int c) {
        //防止越界
        int max = (int) Math.sqrt(c);
        for (int i = 0; i <= max; i++) {
            //i^2+j^2=c
            int lo = 0, hi = max;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (mid * mid == (c - i * i)) {
                    return true;
                } else if (mid * mid < (c - i * i)) {
                    lo=mid+1;
                } else if (mid * mid > (c - i * i)) {
                    hi=mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(33));
    }
}
