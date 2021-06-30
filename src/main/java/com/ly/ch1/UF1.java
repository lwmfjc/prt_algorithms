package com.ly.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * union-find的实现
 */
public class UF1 {
    private int[] id; //分量id(以触点作为索引)
    private int count;//分量数量
    public UF1(int N){
        count=N;
        id=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
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
         id[pRoot]=qRoot;
         count--;
    }
    public int[] getId(){
        return id;
    }

    public static void main(String[] args) {
        int N= StdIn.readInt();
        UF1 uf=new UF1(N);
        while (!StdIn.isEmpty()){
            int p=StdIn.readInt();
            int q=StdIn.readInt();
            if(uf.connected(p,q)){
                continue;
            }
            uf.union(p,q);
            StdOut.println(p+" "+q);
        }
        int[] ids = uf.getId();
        for(int n=0;n<ids.length;n++){
            System.out.printf("%6d--%3d\n",n,ids[n]);
        }
        StdOut.println(uf.count()+"components");
    }
}
