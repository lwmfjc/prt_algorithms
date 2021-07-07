package com.ly.ch2_exp;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch stopwatch=new Stopwatch();
        switch (alg){
            case "Insertion":
                InsertSort.sort1 (a);
                break;
            case "Selection":
                SelectionSort.sort(a);
                break;
            case "Shell":
                ShellSort.sort(a);
                break;
            case "Merge":
                Merge.sort(a);
                break;
            case "MergeBU":
                MergeBU.sort(a);
                break;
            default:
                break;
        }
        return stopwatch.elapsedTime();
    }
    public static double timeRandomInput(String alg, int N, int T) {
        Double[] a=new Double[N];
        double timeTotal=0.00;
        //生成T个N长度的数组
        for(int t=0;t<T;t++){
            for(int n=0;n<N;n++){
                //生成一个随机的double值
                a[n]= StdRandom.uniform();
            }
            StdOut.println("数据生成完毕:");
            timeTotal+=time(alg,a);
            if(!alg.equals("Selection") )
            {
                assert BaseSort.isSorted(a);
            }
        }
        return timeTotal;
    }

    public static void main(String[] args) {
        int N=Integer.parseInt(args[0]);//数组长度
        int T=Integer.parseInt(args[1]);//数组个数
        String alg1=args[2];//算法1
        String alg2=args[3];//算法2
        String alg3=args[4];//算法3
        String alg4=args[5];//算法4
        String alg5=args[6];//算法5
        /*System.out.printf("%s---%f\n",alg1,timeRandomInput(alg1,N,T));
        System.out.printf("%s---%f\n",alg2,timeRandomInput(alg2,N,T));
        System.out.printf("%s---%f\n",alg3,timeRandomInput(alg3,N,T));
        System.out.printf("%s---%f\n",alg4,timeRandomInput(alg4,N,T));*/
        System.out.printf("%s---%f\n",alg5,timeRandomInput(alg5,N,T));

    }
}
