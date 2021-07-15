package com.ly.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution455 {
    private int searchBinary(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == a[key]) {
                return mid;
            } else if (a[key] > a[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int get = 0;
        for (int i = 0, j = 0; i < g.length; i++) {
            while (j < s.length) {
                if (s[j++] >= g[i]) {
                    get++;
                    break;
                }
            }
            if (j > s.length - 1) {
                break;
            }
        }
        return get;

    }

    public static void main(String[] args) {
        System.out.println(new Solution455().findContentChildren(new int[]{1,2}, new int[]{1,2,3})
        );
    }
}
