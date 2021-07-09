package com.ly.leetcode;

import com.ly.ch2.BaseSort;

import java.util.Arrays;

public class Solution1051 extends BaseSort {
    public int heightChecker(int[] heights) {
        int[] copys = Arrays.copyOf(heights, heights.length);
        int N = heights.length;
        int total = 0;
        for (int n = 1; n < N; n++) {
            int temp = heights[n];
            int j = n;
            for (; j >= 1 && temp < heights[j - 1]; j--) {
                heights[j] = heights[j - 1];
            }
            heights[j] = temp;
        }
        for (int n = 0; n < heights.length; n++) {
            if(copys[n]!=heights[n]){
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a={5,1,2,3,4};
        // int[] a = {1, 2, 3, 4, 5};
        System.out.println(new Solution1051().heightChecker(a));
    }
}
