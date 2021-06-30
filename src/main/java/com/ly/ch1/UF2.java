package com.ly.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * quick-union加权的实现(树基础上加权)
 */
public class UF2 {
    private int[] id; //分量id(以触点作为索引)
    private int[] sz;//(由触点索引的)各个根节点所对应的分量的大小
    private int count;//分量数量
    public UF2(int N){
        count=N;
        id=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
        }
        sz=new int[N];
        for(int i=0;i<N;i++){
            sz[i]=1;
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public int find(int p){
        while(p!=id[p]){
            p=id[p];
        }
        return p;
    }
    public void union(int p,int q){
         int pRoot=find(p);
         int qRoot=find(q);
         if(pRoot==qRoot){
             return ;
         }
         //将小树的根节点连接到大树的根节点
        if(sz[pRoot]<sz[qRoot]){
            id[pRoot]=qRoot;//p连向q
            sz[qRoot]+=sz[pRoot];
        }else {
            id[qRoot]=pRoot; //q连向p
            sz[pRoot]+=sz[qRoot];
        }

         count--;
    }
    public int[] getId(){
        return id;
    }

    public static void main(String[] args) {
        int N= StdIn.readInt();
        UF2 uf=new UF2(N);
        Stopwatch timer=new Stopwatch();
        while (!StdIn.isEmpty()){
            int p=StdIn.readInt();
            int q=StdIn.readInt();
            if(uf.connected(p,q)){
                continue;
            }
            uf.union(p,q);
            StdOut.println(p+" "+q);
        }
        /*int[] ids = uf.getId();
        for(int n=0;n<ids.length;n++){
            System.out.printf("%6d--%3d\n",n,ids[n]);
        }*/
        StdOut.println(uf.count()+"components");
        StdOut.println(uf.count()+"components");
        StdOut.println(timer.elapsedTime()+" seconds");
    }
}
