package com.ly.ch4_exp1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {
    private ST<String, Integer> st;//符号表->索引
    private String[] keys;
    private Graph G;

    /**
     * @param stream 文件名
     * @param sp     分隔符
     */
    public SymbolGraph(String stream, String sp) {
        st = new ST<>();
        In in = new In(stream);
        //将符号与索引对应
        while (in.hasNextLine()) {
            //用sp分割
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        G = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

}
