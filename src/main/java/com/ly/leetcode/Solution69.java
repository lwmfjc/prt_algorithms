package com.ly.leetcode;

public class Solution69 {
    private int search(int key, int[] a) {
        int N = a.length - 1;
        int lo = 0, hi = N;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key < a[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int lo = 1;

        int hi= x-1 ;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //这里不能用乘法判断,会导致溢出,改用除法(偷看评论区的)
            //long square = mid * mid;
            int result=x/mid;
            if (result == mid) {
                return mid;
            } else if (mid<result) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo - 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 54, 2, 3, 55, 43, 3};
        Solution69 solution69 = new Solution69();
        //System.out.println(solution69.search(3, a));
       // System.out.println(solution69.mySqrt(2147395599));
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        System.out.println(solution69.mySqrt(Integer.MAX_VALUE));
    }
}
