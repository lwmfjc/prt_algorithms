package com.ly.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Iterable后面的Item要填写,不然foreach遍历的时候找不到正确类型
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first;//链表首结点
    private int N;//元素数量

    @Override
    public Iterator<Item> iterator() {
        return new LyIterator();
    }
    private class LyIterator implements Iterator<Item> {
        //当前指向最上面的那个
        private Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }
    }

    //定义了结点的嵌套类
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    public void add(Item item){
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        //新的first指向原来的引用
        first.next=oldfirst;
        N++;
    }
    public static void main(String[] args) {
        Bag<String> s=new Bag<String>();
        while (!StdIn.isEmpty()){
            String item=StdIn.readString();
            if(item.equals("#")){
                break;
            }
            if(!item.equals("-")){
                s.add(item);
            }
        }
        StdOut.println("("+s.size()+" left on stack");
        for(String s1:s){
            System.out.println(s1);
        }
    }
}

