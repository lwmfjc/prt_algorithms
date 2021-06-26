package com.ly.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class FixedCapacityStackOfStrings<Item>
implements Iterable<Item>{
    private Item[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if(N==a.length){
            //元素已经满了
            resize(2*a.length);
        }
        a[N++] = item;
    }

    public Item pop() {
        Item item=a[--N];
        a[N]=null;
        if(N>0&&N==a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    private void resize(int max){
        Item[] temp=(Item[])new Object[max];
        for(int i=0;i<N;i++){
            temp[i]=a[i];
        }
        a=temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i=N;//当前下标
        @Override
        public boolean hasNext() {
            System.out.println((i>0?"还有元素":"没元素了"));
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings<String> s;
        s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(item.equals("#")){
                break;
            }
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.println(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
        for (String s1:s){
            StdOut.println(s1);
        }
    }
}
