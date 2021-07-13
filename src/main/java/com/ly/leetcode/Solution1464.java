package com.ly.leetcode;

public class Solution1464 {
    /**
     * 进行下沉
     *
     * @return
     */
    private void sink(int[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && a[j + 1] > a[j]) {
                j++;
            }
            if (!(a[k] < a[j])) {
                break;
            }
            int temp = a[j];
            a[j] = a[k];
            a[k] = temp;
            k = j;
        }
    }

    public int maxProduct(int[] nums) {
        if (nums.length < 3) {
            return (nums[0] - 1) * (nums[1] - 1);
        }
        int[] copy = new int[nums.length + 1];
        int N = copy.length;
        for (int i = 1; i < N; i++) {
            copy[i] = nums[i - 1];
        }
        for (int k = (N - 1) / 2; k >= 1; k--) {
            sink(copy, k, N - 1);
        }
        int a1 = copy[1];
        int a2 = copy[2];
        int a3 = copy[3];
        return (a1 - 1) * (Math.max(a2, a3) - 1);

    }

    public static void main(String[] args) {
        System.out.println(new Solution1464().maxProduct(new int[]{1, 5, 4, 5}));
    }
}
