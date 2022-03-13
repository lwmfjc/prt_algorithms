package com.ly.recusive;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;//没找到
    }

    public static void main(String[] args) {
        //从文件读取白名单列表
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);//排名
        //
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            //如果不在白名单中则打印出
            if (rank(key, whitelist) == -1) {
                StdOut.println(key);
            }
        }
    }
}
