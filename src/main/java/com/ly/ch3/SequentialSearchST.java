package com.ly.ch3;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class SequentialSearchST<Key, Value> {
    private class Node {
        //链表结点的定义
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private Node first;//链表首结点

    public Value get(Key key) {
        //查找给定的键,返回相关联的值
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val; //命中
            }
        }
        return null; //未命中
    }

    private Iterable<Key> keys() {
        return MyIterator::new;
    }

    private class MyIterator implements Iterator<Key> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Key next() {
            Key key = current.next.key;
            current = current.next;
            return key;
        }
    }

    public boolean contains(Key word) {
        return get(word) != null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return; //命中,更新
            }
        }

        first = new Node(key, val, first);//为命中,新建结点
    }

    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);//最小键长
        SequentialSearchST<String, Integer> st =
                new SequentialSearchST<>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            //忽略较短的单词
            if (word.length() < minlen) continue;
            //不存在的
            if (!st.contains(word)) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }
        }
        System.out.println("数据准备完毕,开始查找----");
        //找出频率最高的单词
        String max = " ";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        StdOut.println(max + " " + st.get(max));
    }

}
