package com.ly.ch1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;

/**
 * 使用第三方库中的Bag存储值,然后遍历计算平均值
 */
public class Stats {
    private static void bagsTest(){
        Bag<Double> numbers= new Bag<>();
        while (!StdIn.isEmpty()){
            numbers.add(StdIn.readDouble());
        }
        int N=numbers.size();
        double sum=0.0;
        for (double x:numbers){
            sum +=x;
        }
        double mean=sum/N;
        System.out.println("平均值:"+mean);
    }
    public static void main(String[] args) {
        bagsTest();
    }
}
