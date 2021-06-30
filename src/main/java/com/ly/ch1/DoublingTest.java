package com.ly.ch1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 随机生成N个数,然后查找threeSum个数,并返回消耗时间
 */
public class DoublingTest {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i]= StdRandom.uniform(-MAX,MAX);
        }
        Stopwatch timer=new Stopwatch();
        int cnt=ThreeSum.count(a);
        //返回查找缩耗费的时间
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        for(int N=250;true;N+=N){
            double time=timeTrial(N);
            StdOut.printf("%7d %5.1f\n",N,time);
        }
    }
}
