package com.ly.leetcode;

import com.ly.ch2.BaseSort;

public class Solution215 {
    private void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int high) {
        if (lo >= high) {
            return;
        }
        int j = partition(nums, lo, high);
        sort(nums, lo, j);
        sort(nums, j + 1, high);

    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int[] nums, int lo, int high) {
        int i = lo, j = high + 1;
        int v = nums[lo];
        while (true) {
            //找到比v小的下标
            while (nums[++i] - v <= 0) {
                //相等就表明不能再继续往下循环了
                if (i == high) {
                    break;
                }
            }
            //找到比v大的下标
            while (v - nums[--j] <= 0) {
                //相等就表明不能再继续往下循环了
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        int[] a = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = solution215.findKthLargest(a, 4);
        for (int i : a) {
            System.out.printf("%3d", i);
        }
        System.out.println(kthLargest);
    }
}
