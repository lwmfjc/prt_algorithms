package com.ly.ch4_exp2;

import com.ly.ch1.Stack;
import com.ly.ch4_exp1.Graph;
import edu.princeton.cs.algs4.In;

//检查有向图是否存在环
public class DirectedCycle {
    private boolean[] onStack;
    private boolean[] marked;
    private Stack<Integer> cycle;
    private int[] edgeTo;//记录路径
    private boolean hasCycle;//存在环

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : G.adj(v)) {
            if (this.hasCycle()) {
                return;
            }else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle=new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        DirectedCycle cycle=new DirectedCycle(G);
        if(cycle.hasCycle()){
            final Iterable<Integer> cycle1 = cycle.cycle();
            for(int i:cycle1){
                System.out.print(i+" ");
            }
        }
    }

}
