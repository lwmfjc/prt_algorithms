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
        /*bst1.put(50, "L50");
        bst1.put(10, "L10");
        bst1.put(80, "L80");
        bst1.put(70, "L70");
        bst1.put(20, "L20");
        bst1.put(2, "L2");
        bst1.put(60, "L60");*/
        /*bst1.put(1, "L1");
        bst1.put(3, "L3");
        bst1.put(6, "L6");
        bst1.put(8, "L8");
        bst1.put(10, "L10");
        bst1.put(15, "L15");
        bst1.put(20, "L20");
        bst1.put(25, "L25");*/
        /*bst1.put(50, "L50");
        bst1.put(40, "L40");
        bst1.put(60, "L60");
        bst1.put(31, "L31");
        bst1.put(45, "L45");
        bst1.put(55, "L55");
        bst1.put(80, "L80");
        bst1.put(29, "L29");
        bst1.put(35, "L35");
        bst1.put(70, "L70");
        bst1.put(28, "L28");*/
        bst.put("A","0A");
        bst.put("C","0C");
        bst.put("E","0E");
        bst.put("H","0H");
        bst.put("J","0J");
        bst.put("L","0L");
        bst.put("M","0M");
        bst.put("P","0P");
        bst.put("R","0R");
        bst.put("S","0S");
        bst.put("Z","0Z");
         /* bst.put("M", "0M");
        bst.put("J", "0J");
        bst.put("R", "0R");
        bst.put("E", "0E");
        bst.put("L", "0L");
        bst.put("P", "0P");
      bst.put("X", "0X");
        bst.put("C", "0C");
        bst.put("H", "0H");
        bst.put("S", "0S");
        bst.put("A", "0A");*/
        // bst.put("Z","0Z");
        bst.levelOrder();
        int k = 1;
        for (char i = 'a'; i <= 'z'; i++) {
           // System.out.print(i);
            //System.out.print("[" + k++ + "]--");
        }

        /*bst1.put(1, "L1");
        bst1.put(2, "L2");
        bst1.put(3, "L3");
        bst1.put(4, "L4");
        bst1.put(5, "L5");
      bst1.put(6, "L6");
         bst1.put(7, "L7");
         bst1.put(8, "L8");
        bst1.put(9, "L9");
        bst1.put(10, "L10");
        bst1.put(11, "L11");*/

        bst1.levelOrder();
    }
}
