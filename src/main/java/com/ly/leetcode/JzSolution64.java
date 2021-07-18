package com.ly.leetcode;

public class JzSolution64 {
    public int sumNums(int n) {
        boolean x = n > 0 && (n += sumNums(n)) > 0;
        return n;

    }
}
