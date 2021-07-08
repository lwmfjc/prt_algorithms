package com.ly.leetcode;

public class Solution164 {

    private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 插入排序(优化)
     *
     * @param nums
     * @return
     */
    public static int maximumGap2(int[] nums) {
        int N = nums.length;
        if (N < 2) {
            return 0;
        }
        for (int i = 1; i < N; i++) {
            int j = i;
            int temp = nums[j];
            for (; j >= 1 && temp < nums[j - 1]; j -= 1) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
        int distanceMax = nums[1] - nums[0];
        for (int i = 2; i < N; i++) {
            int tempDistance = nums[i] - nums[i - 1];
            if (tempDistance > distanceMax) {
                distanceMax = tempDistance;
            }
        }
        return distanceMax;
    }

    /**
     * 插入排序
     *
     * @param nums
     * @return
     */
    public static int maximumGap1(int[] nums) {
        int N = nums.length;
        if (N < 2) {
            return 0;
        }
        for (int i = 1; i < N; i++) {
            for (int j = i; j >= 1 && (nums[j] - nums[j - 1]) < 0; j -= 1) {
                exch(nums, j, j - 1);
            }
        }
        int distanceMax = nums[1] - nums[0];
        for (int i = 2; i < N; i++) {
            int tempDistance = nums[i] - nums[i - 1];
            if (tempDistance > distanceMax) {
                distanceMax = tempDistance;
            }
        }
        return distanceMax;
    }

    /**
     * 归并排序
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        sort(nums);
        int distanceMax = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            int tempDistance = nums[i] - nums[i - 1];
            if (tempDistance > distanceMax) {
                distanceMax = tempDistance;
            }
        }
        return distanceMax;
    }

    //辅助数组
    private int[] aux;

    /**
     * 排序
     *
     * @param a
     */
    private void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    //
    private void merge(int[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        Solution164 solution164=new Solution164();
        System.out.println(solution164.maximumGap(new int[]{1, 222, 56, -5, 4}));
    }
}
