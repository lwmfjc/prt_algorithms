package com.ly.ch2;

import edu.princeton.cs.algs4.StdRandom;

public class Quick3Way extends BaseSort {
    public static void sort(Comparable[] a) {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        //lt指向第一个和v重复的值的下标
        Comparable v = a[lo];
        //排序后lt之前小于v；lt...gt之间等于v；gt之后大于v；
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                //如果i指向的值比v小,a[i]和v交换，然后把lt++,i++记续下一个元素遍历
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                //如果i指向的值比v大,a[i]和a[gt]交换,然后gt--
                exch(a, i, gt--);
                //注意这里,gt指向大于v的那个值的前一个下标
            } else {
                //如果找到了相等的数值,那么什么都不用做,i++继续下一个元素遍历
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);

    }

    public static void main(String[] args) {
//  String[] a= In.readStrings();
        Integer[] a=new Integer[]{99, 1, 3, 1, 4, 5, 1, 2, 44, 2, 1, 1};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
