package com.ly.ch3;

import com.ly.ch1.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    /**
     * a[2]=3,a[3]=5
     * 如果key=6,比mid的大,结果lo=3+1,hi=3;
     * 如果key=4,比mid的小,结果lo=3,hi=3-1;
     * 如果要查找的值key
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        //此时lo>hi
        //如果没有找到,就返回大于Key的最小值
        return lo;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        //注意,这里返回值有可能等于N(且没找到)
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        //注意,这里返回值有可能等于N(且没找到)
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        //从位置N开始赋值,一直到i+1
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }


    public boolean contains(Key word) {
        int rank = rank(word);
        return word == select(rank);
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    /**
     * 排名为k的键(从0开始)
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        return keys[k];
    }

    //大于等于key的最小值
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    //小于等于key的最大值
    public Key floor(Key key) {
        int i = rank(key);
        if (select(i) == key) {
            return key;
        } else   {
            return select(i - 1);
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * rank与celling一个意思,大于等于key的最小值
     *
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }
        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }
        return q;
    }

    public Iterable<Key> keys() {
        return keys(select(0), select(N - 1));
    }

    public static void main(String[] args)   {
        int minlen = Integer.parseInt(args[0]);//最小键长
        BinarySearchST<String, Integer> st =
                new BinarySearchST<>(1610829);
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
