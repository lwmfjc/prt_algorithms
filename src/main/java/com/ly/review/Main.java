package com.ly.review;

import com.ly.ch2.BaseSort;
import edu.princeton.cs.algs4.In;

public class Main extends BaseSort {

    //三向快速排序
    public static void quick3Way(Comparable[] a, int lo, int hi) {
        {
            if (hi <= lo) {
                return;
            }
            int lt = lo, i = lo + 1, gt = hi;
            //a[lt..gt]之间放的是相等的元素
            //换句话说,lt指向最边缘的 与v相等元素的下标 ,
            Comparable v = a[lo];
            while (i <= gt) {
                int cmp = a[i].compareTo(v);
                if (cmp < 0) {
                    exch(a, i++, lt++);
                } else if (cmp > 0) {
                    exch(a, i, gt--);
                } else {
                    i++;
                }
            }
            quick3Way(a, lo, lt - 1);
            quickSort(a, gt + 1, hi);

        }

    }

    /**
     * 下沉
     *
     * @param a
     */
    private static void sink(Comparable[] a, int k, int n) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(a[j], a[j + 1])) {
                j++;
            }
            if (!less(a[k], a[j])) {
                break;
            }
            exch(a, j, k);
            k = j;
        }
    }


    /**
     * 堆排序
     *
     * @param a
     */
    public static void heapSort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n + 1];
        for (int k = 0; k < n; k++) {
            aux[k + 1] = a[k];
        }
        //将数组处理成堆
        for (int k = n / 2; k >= 1; k--) {
            sink(aux, k, n);
        }
        while (n > 1) {
            exch(aux, 1, n--);
            sink(aux, 1, n);
        }

        for (int k = 0; k < a.length; k++) {
            a[k] = aux[k + 1];
        }
    }

    private static Comparable[] aux;

    /**
     * 归并排序
     *
     * @param a
     */
    public static void mergeSort1(Comparable[] a) {
        aux = new Comparable[a.length];
        mergeSort11(a);
    }

    /**
     * 非递归完成排序
     *
     * @param a
     */
    public static void mergeSort11(Comparable[] a) {
        int length = a.length;
        for (int N = 1; N < length; N += N) {
            for (int i = 0; i < length - N; i += (N + N)) {
                merge(a, i, i + N - 1, Math.min(i + N + N - 1, length - 1));
            }
        }
    }


    /**
     * 归并排序
     *
     * @param a
     */
    public static void mergeSort(Comparable[] a) {
        aux = new Comparable[a.length];
        mergeSort(a, 0, a.length - 1);
    }


    /**
     * 归并排序递归
     *
     * @param a
     * @param lo
     * @param hi
     */
    public static void mergeSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        if (!less(a[mid + 1], a[mid])) {
            return;
        }
        merge(a, lo, mid, hi);

    }

    /**
     * 归并排序具体
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (!less(aux[j], aux[i])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    /**
     * 切分
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (j <= i) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    /**
     * 快速排序
     *
     * @param a
     * @param lo
     * @param hi
     */
    public static void quickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    /**
     * 快速排序
     *
     * @param a
     */
    public static void quick(Comparable[] a) {

    }

    /**
     * 冒泡排序
     *
     * @param a
     */
    public static void bubbling(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            //真正的冒泡,上面的i用来记录已经排了几个
            for (int j = 0; j < a.length - i - 1; j++) {
                if (less(a[j + 1], a[j])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param a
     */
    public static void selectSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }

    /**
     * 希尔排序
     *
     * @param a
     */
    public static void shellSort(Comparable[] a) {
        int length = a.length;
        int h = 1;
        while (h < length / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = 1; i < length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    /**
     * 插入排序
     *
     * @param a
     */
    public static void sortInsert2(Comparable[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            Comparable tempJ = a[i];
            int j = i;
            for (; j >= 1 && less(tempJ, a[j - 1]); j--) {
                //往后移
                a[j] = a[j - 1];
            }
            a[j] = tempJ;
        }
    }

    /**
     * 插入排序
     *
     * @param a
     */
    public static void sortInsert(Comparable[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j >= 1 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }


    public static void main(String[] args) {
        String[] strings = In.readStrings();
        quick3Way(strings,0,strings.length-1);
        assert isSorted(strings);
        show(strings);
    }
}
