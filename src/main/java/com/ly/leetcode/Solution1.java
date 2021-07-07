package com.ly.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 一共做了两题，一次没用暴力 emmm，我的非暴力率也有50% 了哈哈哈
 * 记录下给自己个鼓励^_^
 * emmm...初学算法,感觉O(n)=n*lgn吧应该
 */
public class Solution1 {
    private static int search(int key, int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i :
                nums1) {
            set.add(i);
        }

        Arrays.sort(nums2);
        Set<Integer> set1 = new HashSet<>();
        for (int i : set) {
            if (search(i, nums2) != -1) {
                set1.add(new Integer(i));
            }
        }
        int[] result=new int[set1.size()];
        int n=0;
        for (int a : set1) {
            result[n++]=a;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 3, 4, 2, 3, 4, 3, 10};
        int[] a2 = new int[]{1, 3, 4, 12, 32, 4, 3, 10};
        System.out.println(Arrays.toString(intersection(a1, a2)));
    }
}
