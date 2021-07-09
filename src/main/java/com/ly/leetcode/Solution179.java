package com.ly.leetcode;

import java.util.Arrays;

public class Solution179 {
    public boolean isLess(int i, int j) {
        return ("" + i + j).compareTo("" + j + i) < 0;
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public String largestNumber(int[] nums) {
        int N = nums.length;
        //判断全是零
        int n = N;
        while (n > 0) {
            if (nums[--n] != 0) {
                n = -1;
            }
        }
        if (n == 0) {
            return "0";
        }

        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && isLess(nums[j], nums[j - h]); j -= h) {
                    exch(nums, j, j - h);
                }
            }
            h = h / 3;
        }
        StringBuilder result = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) {
            result.append(nums[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution179 solution179 = new Solution179();
        System.out.println(solution179.largestNumber(new int[]{55,4,9,1,22,34,4,1}));
    }
}
