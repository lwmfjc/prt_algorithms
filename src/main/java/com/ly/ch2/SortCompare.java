package com.ly.ch2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        }else if (alg.equals("Selection")) {
            Selection.sort(a);
        }else if(alg.equals("Shell")){
            Shell.sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        //使用算法alg将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
           // System.out.println("数据生成完毕-----");
            total += time(alg, a);
            assert BaseSort.isSorted(a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        String alg3 = args[2];
        int N = Integer.parseInt(args[3]);
        int T = Integer.parseInt(args[4]);
        //算法1的总时间 插入排序
        double t1 = timeRandomInput(alg1, N, T);
        StdOut.printf("%s[%f]\n",alg1,t1);
        //算法2的总时间 选择排序
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("%s[%f]\n",alg2,t2);
        double t3 = timeRandomInput(alg3, N, T);
        StdOut.printf("%s[%f]\n",alg3,t3);
         /*StdOut.printf("For %d random Doubles\n  %s is ", N, alg1);
        StdOut.printf("%.1f times faster than %s\n",t2/t1,alg2);*/
    }
}
