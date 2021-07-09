package com.ly.leetcode;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) throws Exception {
        if (nums1.length != m + n) {
            throw new Exception("数组长度有误");
        }
        int m1 = m - 1;
        int n1 = n - 1;
        for (int k = nums1.length - 1; k >= 0; k--) {
            if (m1 < 0) {
                nums1[k] = nums2[n1--];
            } else if (n1 < 0) {
                nums1[k] = nums1[m1--];
            } else if (nums1[m1] > nums2[n1]) {
                nums1[k] = nums1[m1--];
            } else {
                nums1[k] = nums2[n1--];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[] nums1 = new int[]{1, 2, 3, 5, 7, 0, 0, 0, 0};
        int[] nums2 = new int[]{2, 3, 5, 6, 0, 0, 0, 0};
        Solution88 solution88 = new Solution88();
        solution88.merge(nums1, 5, nums2,4);
        for (int i :
                nums1) {
            System.out.printf("%3d", i);

        }
    }
}
