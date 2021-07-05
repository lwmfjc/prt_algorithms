package com.ly.ch2;

import edu.princeton.cs.algs4.In;

public class Shell extends BaseSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        //对应
        //-,(1+1)*3,(4+1)*3
        //1,4,13,40,121,364...
        //n<6,h=1;n<9,h=4;
        //注意,这里是整数相除,没有小数点
        //h>=N/3
        /*for(int k=1;k<2000;k++) {
            int h1=1;
            while (h1 < k / 3) {
                h1 = 3 * h1 + 1;
            }
            System.out.printf("k[%d]-h[%d]\n",k,h1);
        }*/

        //h>=N/3
        while (h < N / 3) {
            //h的表达式
            h = 3 * h + 1;
        }

        while (h >= 1) {
            //h=1,4,13,40,121,364,1039,...
            //当h=1的时候,就是插入排序
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
         String[] a= In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
