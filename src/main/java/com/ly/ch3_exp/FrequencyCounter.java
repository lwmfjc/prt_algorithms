package com.ly.ch3_exp;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

/**
 * 符号表的用例
 */
public class FrequencyCounter {
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if(word.length()<minlen) continue;
            if (st.get(word) != null) {
                st.put(word, st.get(word) + 1);
            } else {
                st.put(word, 1);
            }
        }
        String max = "";
        //key可以为"",不能为null
        st.put(max, 0);
        for (String key : st.keys()) {
            if (st.get(key) > st.get(max)) {
                max = key;
            }
        }
        System.out.printf("[%s]--[%d]", max, st.get(max));
    }
}
