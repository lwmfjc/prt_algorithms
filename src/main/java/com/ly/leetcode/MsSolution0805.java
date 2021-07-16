package com.ly.leetcode;

public class MsSolution0805 {

    public int multiply(int A, int B) {
        if (B == 0) {
            return 0;
        }

        return A+multiply(A, --B);
    }

    public static void main(String[] args) {
        System.out.println(
                new MsSolution0805().multiply(3,100)
        );
    }
}
