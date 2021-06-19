package com.ly.utils;

public class Utils {
    public static int gcd(int p,int q){
        if(q==0){
            return p;
        }
        int r=p%q;
        return gcd(q,r);
    }
}
