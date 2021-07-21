package com.ly.ch3_exp;

import com.ly.ch3.ISearch;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.Queue;

public class BST1<Key extends Comparable<Key>, Value> implements ISearch<Key, Value> {
    private Node root;

    private class Node {
        private Node left, right;
        private int N;
        private Key key;
        private Value val;

        public Node(Key key, Value val, int n) {
            N = n;
            this.key = key;
            this.val = val;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else {
            x.val = val;
        }
        //更新结点数
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    @Override
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    @Override
    public Key floor(Key key) {
        Node node = floor(key, root);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    private Node floor(Key key, Node x) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return floor(key, x.left);
        } else if (cmp == 0) {
            return x;
        } else {
            Node t = floor(key, x.right);
            if (t == null) {
                return x;
            } else {
                return t;
            }
        }
    }

    @Override
    public Key ceiling(Key key) {
        Node node = ceil(key, root);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    private Node ceil(Key key, Node x) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp < 0) {
            Node t = ceil(key, x.left);
            if (t == null) {
                return x;
            } else {
                return t;
            }
        } else {
            return ceil(key, x.right);
        }
    }

    //查找排名为k的结点
    @Override
    public Key select(int k) {
        Node node = select(root, k);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int size = size(x.left);
        if (k == size) {
            return x;
        } else if (k < size) {
            return select(x.left, k);
        } else {
            return select(x.right, k - 1 - size(x.left));
        }
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }

        int tmp = key.compareTo(x.key);
        if (tmp == 0) {
            return size(x.left);
        } else if (tmp < 0) {
            return rank(x.left, key);
        } else {
            return 1 + size(x.left) + rank(x.right, key);
        }
    }

    @Override
    public void deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void deleteMax() {
        deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void delete(Key key) {
        //这里如果没赋值回去,相当于只在函数中的复制的指针进行了一系列操作 root还是指向50
        /*

               50
        10              80
     2    20          70      100
            30     60      90
            如果没有赋值,这个60的结点被删除,其他不变
            如果赋值了, 原结点60被删除,60的结点指向10和80

            因为指针传递的话,如果改变指针.left 能改变left,否则原先的root还是指向原先的位置,为值复制
         */
        root= delete(key, root);
    }

    private Node delete(Key key, Node x) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete(key, x.right);
        } else if (cmp < 0) {
            x.left = delete(key, x.left);
        } else {
            //如果找到了结点
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            //左右结点都存在
            Node t = x;
            //把右半部分最小值拿来当这棵树的根节点
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;

        }
        //删除完之后更新结点的N值
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void print() {
        print(root);
    }

    /**
     * 中序遍历
     *
     * @param x
     */
    private void print(Node x) {
        if (x == null) {
            return;
        }
        print(x.left);
        StdOut.printf("%8s", x.val);
        print(x.right);
    }


    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, min(), max());
        return queue;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);

        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        // 如果这里不添加条件,会把经过的key都遍历进来
        if(x.key.compareTo(lo)>=0&& x.key.compareTo(hi)<=0){
            queue.offer(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }

    public static void main(String[] args) {
        BST1<Integer, String> bst1 = new BST1<>();
        bst1.put(50, "L50");
        bst1.put(10, "L10");
        bst1.put(80, "L80");
        bst1.put(70, "L70");
        bst1.put(20, "L20");
        bst1.put(2, "L2");
        bst1.put(100, "L100");
        bst1.put(60, "L60");
        bst1.put(30, "L30");
        bst1.put(90, "L90");
        bst1.put(120, "L120");
        bst1.put(110, "L110");
        //bst1.print();
        //bst1.deleteMin();
        // bst1.deleteMin();
        bst1.delete(50);
        //bst1.print();
        StdOut.println("------------------");
        StdOut.println(bst1.min());
        StdOut.println(bst1.rank(55));
        StdOut.println("------------------");
        Iterable<Integer> integers=bst1.keys(20,70);
        for (Integer i :integers){
            StdOut.printf("%6s",i);
        }


    }
}
