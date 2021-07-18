package com.ly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MsSolution0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        if (n == 0) {
            return;
        } else {
            hanota(A, C, B, n - 1);
            C.add(A.remove(A.size() - 1));
            hanota(B, A, C, n - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        new MsSolution0806().hanota(A, B, C, A.size());
        for (int i : C) {
            System.out.println(i);
        }

    }

}
