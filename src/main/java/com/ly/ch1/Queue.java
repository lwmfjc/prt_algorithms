package com.ly.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    private class Node{
        Item item;
        Node next;
    }
    private Node first;//指向最早添加的结点的链接
    private Node last;//指向最近添加的结点的链接
    private int N;
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    //向队列添加元素
    //从最后添加
    public void enqueue(Item item){
        Node oldlast=last;
        last=new Node();//重新开辟一块存储空间
        last.item=item;
        last.next=null;
        //如果原先是空链接,
        //即未指定first指向的空间
        if(isEmpty()){
            first=last;
        }else {
            //如果不是空,则oldlast指向新的last
            oldlast.next = last;
        }
        N++;
    }
    public Item dequeue(){
        Item item=first.item;
        first=first.next;
        if(isEmpty()){
            //如果dequeue之后为空,则last应该指向空而不是最后一个元素
            last=null;
        }
        N--;
        return  item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<Item>{
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

    public static void main(String[] args) {
        Queue<String> s=new Queue<String>();
        while (!StdIn.isEmpty()){
            String item=StdIn.readString();
            if(item.equals("#")){
                break;
            }
            if(!item.equals("-")){
                s.enqueue(item);
            }else if(!s.isEmpty()) {
                StdOut.print(s.dequeue()+" ");
            }
        }
        StdOut.println("\n("+s.size()+") left on stack");
        for (String value : s) {
            System.out.print(value+" ");
        }
    }
}
