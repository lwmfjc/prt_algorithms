package com.ly.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * todo 暴力算法时间溢出 待更新
 */
public class Solution315 {
    //临时数组,存储index的值-->一一对应原数组 nums[aux[i]]从原数组取值
    private int[] aux;

    //存储index的值-->一一对应原数组 nums[indexes[i]]从原数组取值
    public int[] indexes;

    public int[] results;

    // private List<Integer> list;

    public ArrayList countSmaller(int[] nums) {
        int N = nums.length;
        ArrayList list = new ArrayList<>(N);
        if (N == 1) {
            list.add(0);
            return list;
        } else if (N == 0) {
            return list;
        }
        results = new int[nums.length];

        indexes = new int[nums.length];

        aux = new int[N];
        //初始化个数
        for (int i = 0; i < N; i++) {
            indexes[i] = i;
            results[i] = 0;
            //list.add(i, 0);
        }
        countSmaller(nums, 0, N - 1);
        for (int i = 0; i < N; i++) {
            list.add(i, results[i]);
        }
        return list;
    }

    private void countSmaller(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        countSmaller(nums, lo, mid);
        countSmaller(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = indexes[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                indexes[k] = aux[j++];
            } else if (j > hi) {
                indexes[k] = aux[i++];
                results[indexes[k]] += (hi - mid);
                // list.set(indexes[k], list.get(indexes[k]) + (hi - mid));
            } else if (nums[aux[i]] <= nums[aux[j]]) {//比较时取出原值比较
                indexes[k] = aux[i++];
                //原来第indexes[k]个数，逆序对个数加多少个,
                //所以应该是拿放完左边的数之后,取出的下标,
                //即下面这条代码要在indexes[k]设置完之后
                results[indexes[k]] += (j - mid - 1);
                //list.set(indexes[k], list.get(indexes[k]) + (j - mid - 1));

            } else {
                //list.set(indexes[k], list.get(k) + (hi + 1 - j));
                indexes[k] = aux[j++];
            }
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 6, 1};
        Solution315 solution315 = new Solution315();
        List<Integer> integers = solution315.countSmaller(a);
        for (int i : a) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : solution315.indexes) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : integers) {
            System.out.print(i);
        }
    }


    /**
     * 溢出了
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller1(int[] nums) {
        //int[] counts = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[j] < nums[i]) {
                    sum++;
                }
            }
            list.add(sum);
        }
        return list;
    }
}
