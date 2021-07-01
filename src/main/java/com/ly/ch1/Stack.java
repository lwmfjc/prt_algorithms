package com.ly.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Iterable后面的Item要填写,不然foreach遍历的时候找不到正确类型
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first;//栈顶(最近添加的元素)
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
    public void push(Item item){
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        //新的first指向原来的引用
        first.next=oldfirst;
        N++;
    }
    public Item pop(){
        Item item=first.item;
        //这里first指向下一个,原来分配的空间没有任何引用指向,就会被回收
        first=first.next;
        N--;
        return item;
    }
    public static void main(String[] args) {
        Stack<String> s=new Stack<String>();
        while (!StdIn.isEmpty()){
            String item=StdIn.readString();
            if(item.equals("#")){
                break;
            }
            if(!item.equals("-")){
                s.push(item);
            }else if(!s.isEmpty()) {
                StdOut.print(s.pop()+" ");
            }
        }
        StdOut.println("("+s.size()+" left on stack");
        for(String s1:s){
            System.out.println(s1);
        }
    }
}

