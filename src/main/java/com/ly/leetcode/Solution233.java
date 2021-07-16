package com.ly.leetcode;

public class Solution233 {
    private int count(int n) {
        String s = n + "";
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                sum++;
            }
        }
        return sum;
    }

    public int countDigitOne(int n) {
        int sum = 0;
        for (int k = 1; k <= n; k++) {
            sum += count(k);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution233().countDigitOne(824883294)
        );
    }
}
