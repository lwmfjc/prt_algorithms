package com.ly.ch2;

/**
 * 归并排序
 */
public class Merge extends BaseSort {
    private static Comparable[] aux;//归并所需的辅助数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    /**
     * 将已排序的a[lo]..a[mid]和已排序
     * 的a[mid+1]...a[hi]进行归并
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a,
                             int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
            //将数组lo-->hi的值拷贝到辅助数组
        }

        //注意这个循环,数组长度决定了比较次数
        //这里称lo->mid为左元素,j->hi为右元素
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                //如果左元素大于mid,即左元素提取完了,
                //则直接将右元素拷过去
                a[k] = aux[j++];
            } else if (j > hi) {
                //如果右元素大于hi,即右元素提取完了,
                //则直接将左元素拷过去
                a[k]=aux[i++];
            }else if(less(aux[j],aux[i])){
                //如果右元素小于左元素,
                //则拷贝右元素
                a[k]=aux[j++];
            }else {
                //如果左元素小于右元素,
                //则拷贝左元素
                a[k]=aux[i++];
            }
        }
    }

    /**
     * 对数组中a[lo]...a[hi]元素进行排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a,
                             int lo,int hi){
        //如果只有一个元素,则不进行排序
        if(hi<=lo){
            return ;
        }
        //sort(0,1)时mid=0,
        // 即lo和hi相差为1时下面的两个sort都不会执行
        //直接执行merge(a,0,0,1)

        //用来取中间元素
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);//将左半边进行排序
        sort(a,mid+1,hi);//将右半边进行排序
        //真正的排序方法,a[lo]..a[mid]和a[mid+1]..a[hi]
        //有序后,就可以进行归并
        merge(a,lo,mid,hi);//将排序结果进行归并
    }
}
