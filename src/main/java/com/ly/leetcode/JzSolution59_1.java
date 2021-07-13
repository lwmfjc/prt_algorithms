package com.ly.leetcode;

import com.ly.ch2.MaxPQ;

import java.util.Arrays;

/**
 * todo 还没写完
 */
public class JzSolution59_1 {
    private void sink(int[] nums, int k, int n) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] <= nums[k]) {
                break;
            }
            k = j;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] copy = new int[k + 1];
        int max = nums.length - 3 + 1;
        int[] result = new int[max];

        for (int i = 0; i < k; i++) {
            copy[i + 1] = nums[i];
        }
        for (int j = k / 2; j >= 1; j--) {
            sink(nums, j, k);
        }
        result[0] = nums[k - 1];
        for (int i = k - 1; i <= max - 1; i++) {
            //result[i]= Math.max(result[i-1])
        }
        return result;


    }

    public static void main(String[] args) {

    }
}
