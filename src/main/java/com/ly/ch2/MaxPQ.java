package com.ly.ch2;

/**
 * 支持插入元素/删除最大元素
 * 插入元素操作不出超过lgN+1次,删除最大元素不超过2lgN次
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable> {
    private Key[] pq; //基于堆的完全二叉树
    private int N = 0;//存储于pq[1..N]中,pq[0]没有使用

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        //添加后上浮
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];//从根节点得到最大元素
        //交换删除后进行下沉
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    /**
     * 由上至下的堆有序化下沉实现
     * @param k
     */
    private void sink(int k) {
        //k要有子节点
        while (2 * k <= N) {
            int j = 2 * k;//左子节点
            //k的左子节点如果有右节点
            //判断它和右节点的大小,取较大的
            if (j < N && less(j, j + 1)) {
                j++;
            }
            //如果k没有比子节点小,循环结束
            //也不需要交换
            if (!less(k, j)) break;
            //将节点跟最大子节点交换
            exch(k, j);
            k = j;
        }
    }

    /**
     * 由下至上的堆有序化上浮的实现
     *
     * @param k
     */
    private void swim(int k) {
        //根节点不需要上浮
        //父节点比当前节点小
        while (k > 1 && less(k / 2, k)) {
            //交换当前节点和父节点
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public static void main(String[] args) {
        MaxPQ<String> maxPQ = new MaxPQ<>(20);
        maxPQ.insert("P");
        maxPQ.insert("Q");
        maxPQ.insert("E");
        maxPQ.delMax();
        maxPQ.insert("X");
        maxPQ.insert("A");
        maxPQ.insert("M");
        maxPQ.delMax();
        maxPQ.insert("P");
        maxPQ.insert("L");
        maxPQ.insert("E");
        maxPQ.delMax();
        while (!maxPQ.isEmpty()){
            System.out.printf("%3s",maxPQ.delMax());
        }

    }
}
