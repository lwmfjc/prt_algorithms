package com.ly.ch2;

import org.w3c.dom.ls.LSInput;

/**
 * 支持插入元素/删除最大元素
 * 插入元素操作不出超过lgN+1次,删除最大元素不超过2lgN次
 *
 * @param <Key>
 */
public class MaxPQSort<Key extends Comparable<Key>> {
    private int N = 0;//存储于pq[1..N]中,pq[0]没有使用

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key[] pq, Key v) {
        pq[++N] = v;
        //添加后上浮
        swim(pq, N);
    }

    public Key delMax(Key[] pq) {
        Key max = pq[1];//从根节点得到最大元素
        //交换删除后进行下沉
        exch(pq, 1, N--);
        pq[N + 1] = null;
        sink(pq, 1, N);
        return max;
    }

    /**
     * 由上至下的堆有序化下沉实现
     * 由下至上的时候会把子节点中节点值大的往上浮动
     * @param k
     */
    private void sink(Key[] a, int k, int N) {
        //k要有子节点
        while (2 * k <= N) {
            int j = 2 * k;//左子节点
            //k的左子节点如果有右节点
            //判断它和右节点的大小,取较大的
            if (j < N && less(a, j, j + 1)) {
                j++;
            }
            //如果k没有比子节点小,循环结束
            //也不需要交换
            if (!less(a, k, j)) break;
            //将节点跟最大子节点交换
            exch(a, k, j);
            k = j;
        }
    }

    /**
     * 由下至上的堆有序化上浮的实现
     * 只要他的父节点比他小,就直接把他往上浮动
     * @param k
     */
    private void swim(Key[] pq, int k) {
        //根节点不需要上浮
        //父节点比当前节点小
        while (k > 1 && less(pq, k / 2, k)) {
            //交换当前节点和父节点
            exch(pq, k / 2, k);
            k = k / 2;
        }
    }

    private void exch(Key[] pq, int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(Key[] pq, int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void sort(Key[] a) {
        int N = a.length - 1;//N表示数组有效数据长度

        //注意这里的初始化,k表示最后一个元素的父节点
        //进行堆有序处理
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        //N为1时就不再处理
        while (N > 1) {
            //1 把最大元素放到最后面
            //2 修复堆有序
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    public static void main(String[] args) {
        String[] a = {"",
                "1", "6","2","8", "7",  "9",
                 "3",  "5","4"};
        MaxPQSort<String> maxPQSort = new MaxPQSort();
        maxPQSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (i == 0) continue;
            System.out.printf("%3s", a[i]);
        }
    }
}
