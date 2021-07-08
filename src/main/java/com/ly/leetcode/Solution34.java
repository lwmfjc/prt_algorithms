package com.ly.leetcode;

import java.util.Arrays;

public class Solution34 {
    public static int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int i = -1, j = -1;
        boolean leftFind = false, rightFind = false, find = false;
        int findMid = -1;
        while (true) {
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == target) {
                    if (!find) { //只记录一次
                        findMid = mid;
                        find = true;
                    }
                    if (!leftFind) {
                        i = mid;
                        hi = mid - 1; //让它往左边找
                    } else if (!rightFind) {
                        j = mid;
                        lo = mid + 1; //让它往右找
                    }
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (!leftFind) {
                leftFind = true;
                lo = Math.max(findMid,0); //左边找到了
                hi = nums.length - 1;
                if (hi < 1) {
                    j = findMid;
                    break;
                }
            } else if (!rightFind) {
                rightFind = true;
            } else {
                break;
            }
        }
        return new int[]{i, j};
    }

    public static int[] searchRange2(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    //leftOrRight为true找左边界 false找右边界
    public static int binarySearch(int[] nums, int target, boolean leftOrRight) {
        int res = -1;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target < nums[mid])
                right = mid - 1;
            else if (target > nums[mid])
                left = mid + 1;
            else {
                res = mid;
                //处理target == nums[mid]
                if (leftOrRight)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 1)));
    }
}
