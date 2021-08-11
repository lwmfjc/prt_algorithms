package com.ly.leetcode;

public class Solution278 {
    private int k;

    private boolean isBadVersion(int k) {
        if (k == this.k) {
            return true;
        } else {
            return false;
        }
    }

    public int firstBadVersion(int n, int k) {
        this.k = k;
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
           /* if (high - low == 1 &&  !isBadVersion(low)) {
                return high;
            }*/
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else if (!isBadVersion(mid)) {
                low = mid + 1;
            }
        }
        return high+1;
    }

    public static void main(String[] args) {
        Solution278 solution278 = new Solution278();
        int r = solution278.firstBadVersion(5, 4);
        System.out.println(r);
    }
}
