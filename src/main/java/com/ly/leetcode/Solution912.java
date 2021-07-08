package com.ly.leetcode;

import java.util.Arrays;

public class Solution912 {
    public int[] aux;

    public int[] sortArray(int[] nums) {
        aux = new int[nums.length];
        sort(nums );
        return nums;
    }

    /**
     * 进行归并
     *
     * @param nums
     * @param lo
     * @param mid
     * @param hi
     */
    public void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }

    public void sort(int[] nums) {
        int length = nums.length;
        for (int N = 1; N < length; N += N) {
            for (int lo = 0; lo < length - N; lo += (N + N)) {
                merge(nums, lo, lo + N - 1, Math.min(lo + N + N - 1,length-1));
            }
        }
    }

    public static void main(String[] args) {
        Solution912 solution912=new Solution912();
        System.out.println(Arrays.toString(solution912.sortArray(new int[]{1, 222, 56, -5, 4})));
    }

}
