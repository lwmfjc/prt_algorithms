package com.ly.leetcode;

public class Solution997 {
    private int[] trustOut;//信任别人
    private int[] trustIn;//被信任

    public int findJudge(int n, int[][] trust) {
        trustOut = new int[n];
        trustIn = new int[n];
        for (int[] w : trust) {
            trustOut[w[0]-1] = trustOut[w[0]-1] + 1;
            trustIn[w[1]-1] = trustIn[w[1]-1] + 1;
        }
        int index = -1;
        for (int out = 0; out < trustOut.length; out++) {
            if (trustOut[out] == 0 && trustIn[out] == n-1) {
                return out+1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution997 solution997 = new Solution997();
        int[][] a = new int[][]{{1, 3}, {2, 3}};
        int num=solution997.findJudge(3, a);
        System.out.println(num);
    }
}
