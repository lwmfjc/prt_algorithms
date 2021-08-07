package com.ly.leetcode;

public class LySolution1 {

    public void sortColors(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i  ;
            int tempJv = nums[j ];
            while (j >= 1 && tempJv < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tempJv;
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{2,0,2,1,1,0};
        LySolution1 lySolution1=new LySolution1();
        lySolution1.sortColors(a);
        for(int i:a){
            System.out.print(i+" ");
        }

    }
}
