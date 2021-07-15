package com.ly.leetcode;

import com.ly.ch2.BaseSort;

/**
 * 有小到大排序,原地(使用三向快速排序)
 */
public class Solution75 extends BaseSort {
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        int v = nums[lo];
        while (i <= gt) {
            int cmt = nums[i] - v;
            if (cmt < 0) {
                exch(nums, lt++, i++);
            } else if (cmt > 0) {
                exch(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, lo, lt - 1);
        sort(nums, gt + 1, hi);
    }

    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{99, 1, 3, 1, 4, 5, 1, 2, 44, 2, 1, 1};
        new Solution75().sortColors(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
