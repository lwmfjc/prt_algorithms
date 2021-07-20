package com.ly.ch3;

public interface ISearch<Key, Value> {
    int size();//树的大小

    Value get(Key key);//得到结点

    void put(Key key, Value val);//添加结点

    Key min();//找到最小的结点

    Key max();//找到最大的结点

    Key floor(Key key);//大于等于key的最小值

    Key select(int k);//选择排名为k的结点

    int rank(Key key);//查找节点在树中的排名

    void deleteMin();//删除最小的结点

}
