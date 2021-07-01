package com.ly.ch1_exp;

import edu.princeton.cs.algs4.StdIn;

public class UF2 {
    private int[] ids;//索引为触点,值为标识
    private int count;//分量个数
    private int[] sz;//每个分量的个数

    public UF2(int n) {
        count=n;
        ids = new int[n];
        //初始化触点所属分量
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        sz=new int[n];
        for (int i = 0; i < n; i++) {
            sz[i] = 1;
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
            //小的连接到大的
            if(sz[vmRoot]<sz[vnRoot]){
                //给小的赋值
                ids[vmRoot]=vnRoot;
                //给大的增加个数
                sz[vnRoot]+=sz[vmRoot];
            }else {
                ids[vnRoot]=vmRoot;
                sz[vmRoot]+=sz[vnRoot];
            }
            //ids[vnRoot]=ids[vmRoot];
        }
    }

    public static void main(String[] args) {
        int num = StdIn.readInt();
        //初始化触点
        UF2 uf = new UF2(num);
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
