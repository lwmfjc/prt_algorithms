package com.ly.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution1114 {
    /*private AtomicInteger ai1=new AtomicInteger();
    private AtomicInteger ai2=new AtomicInteger();
    public Solution1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        ai1.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (ai1.get()!=1){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        ai2.getAndIncrement();
    }

    public void third(Runnable printThird) throws InterruptedException {

        while (ai2.get()!=1){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }*/
    private Semaphore semaphore1=new Semaphore(0);
    private Semaphore semaphore2=new Semaphore(0);
    public Solution1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore1.acquire(1);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        semaphore2.acquire(1);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
    public static void main(String[] args) {

    }
}
