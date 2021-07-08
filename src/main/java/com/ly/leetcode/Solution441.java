package com.ly.leetcode;

public class Solution441 {
    public static int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        //在1..n-1中查找k,使得k*(1+k)/2 < k
        int lo = 1, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // n == mid * (mid + 1) / 2; 这里n和mid成正比
            float i=n * 1.0f / mid;
            float j=(mid + 1) / 2.0f;
            //这里需要用小数进行比较,而不是直接除
            if (i == j ) {
                return mid;
            } else if (i > j) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo - 1;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));
    }
}
