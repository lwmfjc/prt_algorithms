package com.ly.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * todo 暴力算法时间溢出 待更新
 */
public class Solution315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] copy = Arrays.copyOf(nums, nums.length);

        return list;
    }

    /**
     * 溢出了
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller1(int[] nums) {
        //int[] counts = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[j] < nums[i]) {
                    sum++;
                }
            }
            list.add(sum);
        }
        return list;
    }
}
