package com.ly.leetcode;

public class Solution66 {

    /**
     * 评论区的另一个算法
     * @param digits
     * @return
     */
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    public int[] plusOne(int[] digits) {
        boolean canUp = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                canUp = false;
                break;
            }
        }
        if (canUp) {
            int[] a = new int[digits.length + 1];
            a[0] = 1;
            return a;
        } else {
            boolean up = false;
            for (int i = digits.length - 1; i >= 0; i--) {
                int num = digits[i];
                if (i == digits.length - 1) {
                    num++;
                }
                int dgs = (num + (up ? 1 : 0)) % 10;
                digits[i] = dgs;
                if (num + (up ? 1 : 0) >= 10) {
                    up = true;
                } else {
                    up = false;
                }
            }
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 9, 9};
        Solution66 solution66 =
                new Solution66();
        int[] k = solution66.plusOne(a);
        for (int i = 0; i < k.length; i++) {
            System.out.print(k[i] + " ");
        }
    }

}
