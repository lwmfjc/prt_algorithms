package com.ly.recusive;

public class MyTest {
    /**
     * 后面三个参数代表三根柱子
     * @param n
     * @param x 源数据
     * @param y 目标柱
     * @param z 临时柱
     */
    public static void resolve(int n,char x,char y,char z){
        if(n==0){
            return ;
        }
        resolve(n-1,x,z,y);
        System.out.printf("%c-->%c\n",x,y);
        resolve(n-1,z,y,x);
    }
    public static int sumAdd(int n){
        if(n==0){
            return 0;
        }
        return n+sumAdd(n-1);
    }

    public static int fibonacci(int n){
        if(n<2){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void main(String[] args) {
        //resolve(6,'A','B','C');
        System.out.println(fibonacci(11));
    }
}
