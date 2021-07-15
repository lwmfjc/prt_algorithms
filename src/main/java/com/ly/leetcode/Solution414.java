package com.ly.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution414 {


    public int thirdMax1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return quickSort(nums);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] > v) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] < v) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int temp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = temp;
        return j;
    }

    private int quickSort(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int lo = 0, hi = nums.length - 1;
            while (hi > lo) {
                int j = partition(nums, lo, hi);
                if (j == 2) {
                    return nums[2];
                } else if (j > 2) {
                    hi = j - 1;
                } else {
                    lo = j + 1;
                }
            }
            return nums[2];
        }

    }

    /**
     * 暴力
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        nums = new int[set.size()];
        int i = 0;
        for (int k : set) {
            nums[i++] = k;
        }
        return quickSort(nums);

    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        System.out.println(new Solution414().thirdMax(a));
    }
}
