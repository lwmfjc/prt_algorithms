package com.ly.ch1;

import com.ly.old.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumFast {
    public static int count(int[] a){
        Arrays.sort(a);
        int N=a.length;
        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(BinarySearch.rank(-a[i]-a[j],a)>j){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a= In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
