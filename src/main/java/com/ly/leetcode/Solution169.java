package com.ly.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution169 {


    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.merge(i, 1, Integer::sum);
        }
        int num=-1;
        for(int i:nums){
            num=map.get(i);
            if(map.get(i)>nums.length/2){
                return i;
            }
        }
        return num;
    }

}
