package com.ly.leetcode;

public class Solution51 {
    private int[] aux;

    /**
     * 将两部分已排序的数组进行归并
     *
     * @param nums
     * @param lo
     * @param mid
     * @param hi
     */
    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        //先把数值复制到临时数组中
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }

    /**
     * 排序入口
     *
     * @param nums
     */
    private void sort(int[] nums) {
        aux = new int[nums.length];
        //sort1(nums, 0, nums.length - 1);
        sort2(nums, 0, nums.length - 1);
    }

    /**
     * 自底向上归并排序
     *
     * @param nums
     * @param lo
     * @param hi
     */
    private void sort2(int[] nums, int lo, int hi) {
        for (int N = 1; N < nums.length; N += N) {
            //子数组下标
            for (int index = 0; index < nums.length - N; index += (N + N)) {
                merge(nums, index, index + N - 1, Math.min(index + N + N - 1, nums.length));
            }
        }
    }

    /**
     * 自顶向下归并排序
     *
     * @param nums
     * @param lo
     * @param hi
     */
    private void sort1(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort1(nums, lo, mid);
        sort1(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    public int reversePairs1(int[] nums) {
        //将数组进行排序
        sort(nums);

        return -1;
    }

    private int binarySearch(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key == a[mid]) {
                return key;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public int reversePairs2(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            //从后面进行二分查找
                int lo = i+1;
                int hi = nums.length - 1;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (nums[i] == nums[mid]) {
                        total++;
                        break;
                    } else if (nums[i] > nums[mid]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,5,6,4};
        System.out.println(new Solution51().reversePairs1(a));
        /*for (int i : a) {
            System.out.printf("%3d", i);
        }*/
    }
}
