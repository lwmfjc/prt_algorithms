package com.ly.leetcode;

public class JzSolution51 {
    private int[] aux;

    public int reversePairs(int[] nums) {
        int N = nums.length;
        if (N < 2) {
            return 0;
        }
        aux = new int[N];

        return countReversePairs(nums, 0, N - 1);
    }

    private int countReversePairs(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        int leftCount = countReversePairs(nums, lo, mid);
        int rightCount = countReversePairs(nums, mid + 1, hi);
       /* if(nums[mid]<=nums[mid+1]){
            return leftCount + rightCount;
        }*/
        int mergeCount = merge(nums, lo, mid, hi);
        return leftCount + rightCount + mergeCount;
    }

    private int merge(int[] nums, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        int total = 0;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {//这里是拿辅助数组判断,不是原数组判断,☆总是忘记☆
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
                //归并j的时候,计算逆序对
                total += (mid + 1 - i);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a=new int[]{7,5,6,4};
        int count=new JzSolution51().reversePairs(a);
        System.out.println(count);
    }
}
