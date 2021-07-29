package com.ly.ch4._42;

import edu.princeton.cs.algs4.In;

import java.util.Stack;

public class DirectedCycle {
    private int i;
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;//有向环中的所有顶点
    private boolean[] onStack;//递归调用的栈上的所有顶点

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        //顶点v的邻接点w
        for (int w : G.adj(v)) {
            //如果v有相邻顶点且所有相邻顶点都没遍历过,则onStack[v]为false
            if (this.hasCycle()) {
                //StdOut.println(w+"a");
                return;
            } else if (!marked[w]) {//没有遍历过
                edgeTo[w] = v;
                dfs(G, w);
                //StdOut.println(w+"b");
               // System.out.println(++i);
            } else if (onStack[w]) {
                //如果找到了闭环,就会导致所有的递归函数都直接return掉了
                //如果遍历过了,
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
               // StdOut.println(w+"c");
            }
        }
        //StdOut.println( v+"d");
        //System.out.println(++i);
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void test(int k){
        System.out.println("start");
        for(int i=0;i<5;i++){
            if(k==4) return;
            test(i++);
            System.out.println("end1");
        }
        System.out.println("end2");
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        //int s = Integer.parseInt(args[1]);
        System.out.println(G);
        DirectedCycle directedCycle
                =new DirectedCycle(G);
        //  directedCycle.test(3);
        System.out.println("----------------");
        System.out.println(directedCycle.hasCycle());
    }

}
