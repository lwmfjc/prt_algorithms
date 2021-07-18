package com.ly.recusive;

public class MyTest {
    /**
     * 后面三个参数代表三根柱子
     *
     * @param n
     * @param x 源数据
     * @param y 目标柱
     * @param z 临时柱
     */
    public static void resolve(int n, char x, char y, char z) {
        if (n == 0) {
            return;
        }
        resolve(n - 1, x, z, y);
        System.out.printf("%c-->%c\n", x, y);
        resolve(n - 1, z, y, x);
    }

    public static int sumAdd(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumAdd(n - 1);
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void prove(int n) {
        if (n == 0) {
            System.out.printf("根据步骤一，得出P(%d)" +
                    "成立\n", n);
            return;
        }
        prove(n - 1);
        System.out.printf("根据步骤2，可以说'若P(%d)成立，" +
                "则P(%d)也成立'\n", n - 1, n);
        System.out.printf("因此,可以说P%d是成立的\n", n);
    }

    public static void main(String[] args) {
        prove(2);
        //resolve(6,'A','B','C');
        //System.out.println(fibonacci(11));
    }
}
