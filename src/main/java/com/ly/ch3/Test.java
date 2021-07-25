package com.ly.ch3;

import com.ly.ch3_exp.BST1;
import edu.princeton.cs.algs4.*;

public class Test implements Comparable<Test> {

    @Override
    public int compareTo(Test o) {
        return 0;
    }

    public static void main1(String[] args) {
        ST<String, Integer> st;
        st = new ST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }


    public static void main(String[] args) {
        MyRedBlackBST<String, String> bst = new MyRedBlackBST();

        MyRedBlackBST<Integer, String> bst1 = new MyRedBlackBST();
        bst.put("1","A1");
        bst.put("2","A2");
       /* bst.put("3","A3");
        bst.put("4","A4");
        bst.put("5","A5");
        bst.put("6","A5");
        bst.levelOrder();*/
        int k = 1;
        for (char i = 'a'; i <= 'z'; i++) {
           // System.out.print(i);
            //System.out.print("[" + k++ + "]--");
        }

        bst.levelOrder();
    }
}
