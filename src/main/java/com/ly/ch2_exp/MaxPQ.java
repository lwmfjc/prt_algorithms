package com.ly.ch2_exp;

public class MaxPQ<Key extends Comparable<Key>> {
    private int N;
    private Key[] pq;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key deleteMax() {
        Key key = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return key;
    }

    /**
     * 元素上浮
     *
     * @param k
     */
    public void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    /**
     * 元素下沉
     *
     * @param k
     */
    public void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            //存在右节点
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(j, k);
            k = j;
        }
    }

    /**
     * 元素i是否小于j
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        MaxPQ<String> maxPQ = new MaxPQ(20);
        maxPQ.insert("P");
        maxPQ.insert("Q");
        maxPQ.insert("E");
        maxPQ.deleteMax();
        maxPQ.insert("X");
        maxPQ.insert("A");
        maxPQ.insert("M");
        maxPQ.deleteMax();
        maxPQ.insert("P");
        maxPQ.insert("L");
        maxPQ.insert("E");
        maxPQ.deleteMax();
        maxPQ.insert("P");

    }
}
