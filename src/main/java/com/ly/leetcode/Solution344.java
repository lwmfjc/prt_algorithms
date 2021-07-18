package com.ly.leetcode;

public class Solution344 {
    public void reverseString(char[] s) {
        char temp = ' ';
        for (int k = 0; k <= s.length / 2-1; k++) {
            temp = s[k];
            s[k] = s[s.length - 1 - k];
            s[s.length - 1 - k] = temp;
        }

    }
}
