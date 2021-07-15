package com.ly.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * todo 出现重复的情况
 */
public class Solution15 {
    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] < v) {
                if (i == hi) break;
            }
            while (nums[--j] > v) {
                if (j == lo) break;
            }
            if (i >= j) {
                break;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }

        int temp = nums[j];
        nums[j] = nums[lo];
        nums[lo] = temp;
        return j;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);

    }

    private int search(int[] a, int lo1, int key) {
        int lo = lo1;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {

                    int key = -nums[i] - nums[j];
                    int index = search(nums, j + 1, key);
                    if (index != -1) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(key);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
