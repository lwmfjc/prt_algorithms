package com.ly.recusive;

import edu.princeton.cs.algs4.StdRandom;

public class Quick extends BaseSort {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);//消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a,
                            int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); //切分
        sort(a, lo, j - 1); /// 将左半部分a[lo .. j-1]排序
        sort(a, j + 1, hi);//将右半部分a[j+1..hi]排序
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1; //左右扫描指针
        Comparable v = a[lo]; //切分元素
        while (true) {
            //从左往右扫描，如果找到了大于等于v值的数，就退出循环
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            //从右往左扫描，如果找到了小于等于v值得数，就退出循环
            while (less(a[--j], v)) {
                if (j == lo) break;
            }
            if (i >= j) break;//如果i，j相遇则退出循环
            //将左边大于等于v值的数与右边小于等于v值的数交换
            exch(a, i, j);
        }
        //上面的遍历结束后，a[lo+1...j]和a[i..hi]都已经分别有序
        //且a[j]<=a[i]<=a[lo]，所以应该交换a[lo]和a[j](而不是a[i)，因为
        //a[i]有可能大于a[lo]
        exch(a, lo, j);
        //返回a[lo]被交换的位置
        return j;
    }


    public static void main(String[] args) {

    }
}
