package com.ly.ch1_exp;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.Stack;

public class FixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] stacks;
    private int N;//数组当前大小

    public FixedCapacityStack() {
        this.stacks = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (stacks.length == N) {
            resize(stacks.length * 2);
        }
        stacks[N++] = item;
    }

    public Item pop() {
        Item item = stacks[--N];
        if (N < stacks.length / 4) {
            resize(stacks.length / 2);
        }
        return item;
    }

    private void resize(int n) {
        //新数组大于当前的元素大小
        if (n > stacks.length) {
            Item[] temps = (Item[]) new Object[n];
            for (int i = 0; i < stacks.length; i++) {
                temps[i] = stacks[i];
            }
            stacks = temps;
        }

    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }

    /**
     * 注意这里的遍历,应该是先进后出
     */
    private class MyIterator implements Iterator<Item> {
        private int index = N;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public Item next() {
            return stacks[--index];
        }
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> fixedCapacityStack
                =new FixedCapacityStack();
        while (!StdIn.isEmpty()){
            String s = StdIn.readString();
            if("-".equals(s)){
                fixedCapacityStack.pop();
            }else {
                fixedCapacityStack.push(s);
            }
        }
        for (String s:fixedCapacityStack){
            System.out.println(s);
        }
    }
}
