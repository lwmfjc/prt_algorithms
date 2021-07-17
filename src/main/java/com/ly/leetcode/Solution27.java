package com.ly.leetcode;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int repeat = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == val) {
                repeat++;
            } else {
                nums[k - repeat] = nums[k];
            }
        }
        return nums.length - repeat;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 4, 2, 5, 2, 3, 2};
        System.out.println(new Solution27().removeElement(nums, 2));
        for (int i : nums) {
            System.out.println(i);
        }
    }

}
