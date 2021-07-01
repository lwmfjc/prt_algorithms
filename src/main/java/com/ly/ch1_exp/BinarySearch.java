package com.ly.ch1_exp;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key,int[] a){
        int low=0;
        int high=a.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(key==a[mid]){
                return mid;
            }else if(key>a[mid]){
                low=mid+1;
            }else if(key<a[mid]){
                high=high-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums=In.readInts(args[0]);
        Arrays.sort(nums);
        //排序后再进行查找
        while (!StdIn.isEmpty()){
            final int rank = rank(StdIn.readInt(), nums);
            if(rank!=-1){
                System.out.println(nums[rank]);
            }
        }
    }
}
