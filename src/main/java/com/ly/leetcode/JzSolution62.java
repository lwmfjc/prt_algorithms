package com.ly.leetcode;

public class JzSolution62 {
    public void lastRemaining(int n, int current, int m) {
        if (n == 1) {
            return  ;
        }
        System.out.println((current + n) % m);
          lastRemaining(n - 1, (current + n) % m, m);
    }

    public static void main(String[] args) {
        new JzSolution62().lastRemaining(5,0,3);
    }

}
