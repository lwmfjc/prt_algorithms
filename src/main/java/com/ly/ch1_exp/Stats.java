package com.ly.ch1_exp;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

public class Stats {
    public static void main(String[] args) {
        Stack<Double> stacks=new Stack<>();
        while (!StdIn.isEmpty()){
            stacks.push(StdIn.readDouble());
        }
        double sum=0;
        for(double d :stacks){
            sum+=d;
        }
        System.out.printf("平均值为%4.3f\n",sum/stacks.size());
    }
}
