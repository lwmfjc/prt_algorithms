package com.ly.leetcode;

public class Solution29 {
    public int divide1(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        } else if (dividend < 0) {
            return -1;
        }
        return 1 + divide1(dividend - divisor, divisor);

    }

    public int divide2(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        } else if (dividend > 0) {
            return 1;
        }
        return -1 + divide2(dividend + divisor, divisor);
    }


    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        int k = 0;
        if (dividend > 0 && divisor > 0) {
            dividend = dividend - divisor;
            while (dividend >= 0) {
                if (k == Integer.MAX_VALUE) {
                    break;
                }
                k++;
                dividend = dividend - divisor;
            }
            return k;
        } else if (dividend > 0 && divisor < 0) {
            dividend = dividend + divisor;
            while (dividend >= 0) {
                if (k == Integer.MIN_VALUE) {
                    break;
                }
                k--;
                dividend = dividend + divisor;
            }
            return k;
        } else if (dividend < 0 && divisor > 0) {
            dividend = dividend + divisor;
            while (dividend <= 0) {
                if (k == Integer.MIN_VALUE) {
                    break;
                }
                k--;
                dividend = dividend + divisor;
            }
            return k;
        } else {
            boolean dividendMin = dividend == Integer.MIN_VALUE;
            boolean divisorMin = divisor == Integer.MIN_VALUE;
            //边界问题处理
            //都是最小值
            if (dividendMin == divisorMin && dividendMin) {
                return 1;
            } else if (divisorMin) {
                return 0;
            } else if (dividendMin) {
                //两个都小于零,被除数可能超出.除数不超出
                dividend = dividend - divisor;
                while (dividend <= 0) {
                    if (k == Integer.MAX_VALUE) {
                        break;
                    }
                    k++;
                    dividend = dividend - divisor;
                }
                return k;
            } else {
                return -(divide(dividend, -divisor));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution29().divide(2147483647 , 2));
    }
}
