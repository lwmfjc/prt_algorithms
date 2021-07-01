package com.ly.ch1_exp;

import edu.princeton.cs.algs4.StdIn;

public class UF1 {
    private int[] ids;//索引为触点,值为标识
    private int count;//分量个数

    public UF1(int n) {
        count=n;
        ids = new int[n];
        //初始化触点所属分量
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    public int count() {
        return count;
    }

    /**
     * 查找触点所属根分量
     * 访问数组次数为:触点深度*2+1
     *
     * @param i
     * @return
     */
    public int find(int i) {
        while (i!=ids[i]){
            i=ids[i];
        }
        return i;
    }

    public boolean connected(int m, int n) {
        return find(m) == find(n);
    }

    /**
     * 将触点n合并到与m同一个分量
     * @param m
     * @param n
     */
    public void union(int m, int n) {
        int vmRoot = find(m);
        int vnRoot = find(n);
        if (vmRoot != vnRoot) {
            count--;
            ids[vnRoot]=ids[vmRoot];
        }
    }

    public static void main(String[] args) {
        int num = StdIn.readInt();
        //初始化触点
        UF1 uf = new UF1(num);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
        }
        System.out.println("共计["+uf.count()+"]分量");
        for (int i=0;i<uf.ids.length;i++) {
            System.out.printf("%3d---%6d---label[%3d]\n", i, uf.ids[i],uf.find(i));
        }
    }
}
