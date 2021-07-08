package com.ly.leetcode;

import java.util.Arrays;

public class Solution167 {
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int lo = 0, hi = numbers.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (mid != i && numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] a = {5,25,75};
        System.out.println(Arrays.toString(twoSum(a, 100)));
    }
}
