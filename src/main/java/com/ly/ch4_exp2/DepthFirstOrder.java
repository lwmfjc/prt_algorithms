package com.ly.ch4_exp2;

import com.ly.ch1.Queue;
import com.ly.ch1.Stack;
import edu.princeton.cs.algs4.In;

//基于深度优先搜索的顶点排序
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;//前序排序
    private Queue<Integer> post;//后序排序
    private Stack<Integer> reversePost;//逆后序排序

    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre.enqueue(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        //System.out.println(G);
        //System.out.println();
        DepthFirstOrder order = new DepthFirstOrder(G);
        for (int i : order.reversePost()) {
            System.out.print(i + " ");
        }
    }

}
