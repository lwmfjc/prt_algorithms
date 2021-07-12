package com.ly.leetcode;

/**
 * 快速排序练习
 */
public class Solution217 {
    private void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int high) {
        if (lo >= high) {
            return;
        }
        int j = partition(nums, lo, high);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, high);
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] <= v) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] >= v) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            //num[i]和num[j]交换
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        nums[lo] = nums[j];
        nums[j] = v;
        return j;

    }

    public boolean containsDuplicate(int[] nums) {
        quickSort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        Solution217 solution217=new Solution217();
        System.out.println(solution217.containsDuplicate(a));
        for(int i :a){
            System.out.printf("%3d",i);
        }
    }
}
