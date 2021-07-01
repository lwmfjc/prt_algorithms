package com.ly.ch1_exp;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class TreeSum {
    /**
     * 返回有多少组三个整数对和为零
     * @param a
     * @return
     */
    public static int search(int[] a){
        int length=a.length;
        int size = 0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                for(int m=j+1;m<length;m++){
                    if(a[i]+a[j] +a[m] ==0){
                        //System.out.printf("整数对[%5d %5d ]\n",a[i],a[j] );
                        size++;
                    }
                }
            }
        }
        return size;
    }/**
     * 返回有多少组三个整数对和为零
     * @param a
     * @return
     */
    public static int searchQuick(int[] a){
        int length=a.length;
        int size = 0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
               if(BinarySearch.rank(-a[i]-a[j],a)>j){
                   size++;
               }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        //生成随机整数
        //int[] ints = In.readInts(args[0]);
        int MAX=10;
        if(args.length==1) {
            //int N =10;// Integer.parseInt(args[0]);

            int[] ints= In.readInts(args[0]);
            Arrays.sort(ints);
            System.out.println("\n数据准备完----");

            Stopwatch timer;
            timer=new Stopwatch();
            System.out.printf("共有%d整数对和为零\n", searchQuick(ints));
            System.out.printf("二分查找耗时%f s\n",timer.elapsedTime());
            System.out.printf("共有%d整数对和为零\n", search(ints));
            System.out.printf("耗时%f s\n",timer.elapsedTime());
            timer=new Stopwatch();
            /*for (int i :
                    ints) {
                System.out.println(i);
            }*/
        }
    }
}
