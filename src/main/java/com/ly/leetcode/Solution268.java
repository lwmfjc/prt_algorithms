package com.ly.leetcode;

public class Solution268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int k = 0; k < nums.length; k++) {
            sum +=(k- nums[k]);
        }
        sum += nums.length;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution268().missingNumber(new int[]{ 9,6,4,2,3,5,7,0,1}));
    }
}
