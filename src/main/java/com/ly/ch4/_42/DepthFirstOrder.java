package com.ly.ch4._42;


import com.ly.ch1.Queue;
import com.ly.ch1.Stack;

/**
 * 排序(使用深度优先)
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;//前序排序
    private Queue<Integer> post;//后序排序
    private Stack<Integer> reversePost;//逆后序排序

    public DepthFirstOrder(Digraph G) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        //对所有连通分量进行搜索
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre.enqueue(v);
        for (int w : G.adj(v)) {
            //如果没有遍历过
            if (!marked[v]) {
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

    }
}
