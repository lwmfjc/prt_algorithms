package com.ly.ch4;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {
    private ST<String, Integer> st; //符号名-->索引
    private String[] keys;//索引-->符号名
    private Graph G;//图

    public SymbolGraph(String stream, String sp) {
        st = new ST<>();
        In in = new In(stream);
        while (in.hasNextLine()) {
            //读取下一行的字符串
            String[] a = in.readLine().split(sp);
            //为每个不同的字符串关联一个索引
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }
        //用来获得顶点名的反向索引是一个数组
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        G = new Graph(st.size());
        in = new In(stream);
        //开始构造图
        while (in.hasNextLine()) {
            //将每一行第一个顶点和其他顶点相连
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }

    }

    /**
     * 途中是否存在顶点s
     *
     * @param s
     * @return
     */
    public boolean contains(String s) {
        return st.contains(s);
    }

    /**
     * 顶点s所在的索引
     * @param s
     * @return
     */
    public int index(String s) {
        return st.get(s);
    }

    /**
     * 索引代表的符号
     * @param v
     * @return
     */
    public String name(int v){
        return keys[v];
    }

    /**
     * 返回图
     * @return
     */
    public Graph G(){
        return G;
    }


}
