package com.ly.ch2_exp;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
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
     * 上浮
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉
     *
     * @param k
     */
    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            //判断是否有右节点
            //j代表左节点
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

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
