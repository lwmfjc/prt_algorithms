package com.ly.leetcode;

/**
 * todo 对题目理解有问题
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int maxSize = 0;
        int left = 0, right = heights.length - 1;
        while (left < right) {
            int s = (right - left +1) * (Math.min(heights[right], heights[left]));
            if (s > maxSize) {
                maxSize = s;
            }
            if (heights[right] > heights[left]) {
                right--;
            } else {
                left++;
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int max = solution84.largestRectangleArea(heights);
        System.out.println(max);
    }
}
