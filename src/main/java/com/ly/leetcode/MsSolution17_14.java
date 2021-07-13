package com.ly.leetcode;

import com.ly.ch2.BaseSort;

import java.util.Arrays;

/**
 * 17.14
 */
public class MsSolution17_14 extends BaseSort {
    private int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            //找到比它大的值放右边
            while (arr[++i] < arr[lo]) {
                if (i == hi) {
                    break;
                }
            }
            while (arr[--j] > arr[lo]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            //交换值
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int temp = arr[lo];
        arr[lo] = arr[j];
        arr[j] = temp;
        return j;
    }

    public int[] smallestK(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        while (hi > lo) {
            int j = partition(arr, lo, hi);
            if (j == k) {
                break;
            } else if (j > k) {
                hi = j - 1;
            } else {
                lo = j + 1;
            }
        }
        return Arrays.copyOf(arr, k);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int[] a = new MsSolution17_14().smallestK(arr, 4);
        for (int i : a) {
            System.out.printf("%3d", i);
        }
    }

}
