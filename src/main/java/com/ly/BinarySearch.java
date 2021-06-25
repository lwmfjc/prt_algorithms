package com.ly;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {
    public static int rank(int key,int[] a){
        int lo=0;
        int hi=a.length-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(key<a[mid]){
                hi=mid-1;
            }else if(key>a[mid]){
                lo=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        if(args.length<1){
            System.out.println("no whitelist!");
            return ;
        }
        System.out.println("waiting for enter");
        int[] whitelist= In.readInts(args[0]);
        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()){
            int key=StdIn.readInt();
            if(rank(key,whitelist)==-1){
                StdOut.println("Not get "+key);
            }else {

                StdOut.println("get~"+key);
            }
        }
        System.out.println("停止输入~");
    }
}
