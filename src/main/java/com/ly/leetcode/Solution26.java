package com.ly.leetcode;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }

        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Solution26().removeDuplicates(a));
        for(int i :a){
            System.out.printf("%3d",i);
        }
    }
}
