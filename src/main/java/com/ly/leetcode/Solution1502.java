package com.ly.leetcode;

public class Solution1502 {
    private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        int N = arr.length;
        if (N < 3) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            exch(arr, min, i);
        }
        for (int i = 2; i < N; i++) {
            if ((arr[i] - arr[i - 1]) != (arr[i - 1] - arr[i - 2])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[] {2,3,4}));
    }
}
