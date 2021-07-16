package com.ly.ch3_exp;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

public class SequentialSearchST<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private Node first;

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) == 0) {
                x.val = val;
                return;
            }
        }
        //没找到,则创建新的节点,指向原first的位置
        first = new Node(key, val, first);
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) == 0) {
                return x.val;
            }
        }
        return null;
    }

    public void delete(Key key) {
        for (Node x = first, last = null; x != null; x = x.next) {
            if (x.key.compareTo(key) == 0) {
                if (last != null) {
                    last.next = x.next;
                    break;
                }
            }
            last = x;
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        int size = 0;
        Node x = first;
        while (x != null) {
            size++;
            x = x.next;
        }
        return size;
    }

    public Iterable<Key> keys() {
        //使用队列,先进先出
        Queue<Key> q = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            q.enqueue(x.key);
        }
        return q;
    }

    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        SequentialSearchST<String, Integer> st = new SequentialSearchST();

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            //单词长度较短不进行统计
            if (word.length() < minlen) continue;
            if (st.get(word) != null) {
                st.put(word, st.get(word) + 1);
            } else {
                st.put(word, 1);
            }
        }
        String maxKey = "";
        st.put(maxKey, 0);
        st.delete("business");
        st.delete("monsieur");
        for (String word : st.keys()) {
            if (st.get(word) > st.get(maxKey)) {
                maxKey = word;
            }
        }
        System.out.printf("[%s]--[%d]", maxKey,
                st.get(maxKey));

    }


}
