package com.ly.old;

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
                //查询的值比mid小,hi就比mid小
                hi=mid-1;
            }else if(key>a[mid]){
                //查询的值比mid大,hi就比mid大
                lo=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //key=2, lo=0,hi=1-->lo=0,hi=0->hi=-1
        //key=6,lo=0,hi=1-->lo=1,hi=1->lo=2
        //key=4,lo=0,hi=1-->lo=1,hi=1->hi=0
        rank(2, new int[]{3, 5});
        if(args.length<1){
            System.out.println("no whitelist!");
            return ;
        }
        //白名单N个数据数据
        int[] whitelist= In.readInts(args[0]);
        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()){
            //输入M个数
            //输入<<<白名单数据
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
