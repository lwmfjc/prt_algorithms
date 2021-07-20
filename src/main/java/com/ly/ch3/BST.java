package com.ly.ch3;

import edu.princeton.cs.algs4.StdOut;

public class BST<Key extends Comparable<Key>, Value>  {
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;//以该节点为根的子树中的结点总数

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", N=" + N +
                    '}';
        }
    }

    private Node root;//二叉查找树中的根节点

    public int size() {
        return size(root);
    }

    /**
     * 以该结点为根的子树的结点总数
     *
     * @param x
     * @return
     */
    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        //如果找到了直接返回,没找到则继续查找,
        //直到该节点没有子节点了
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    /**
     * 在以某结点为根节点的树里面插入某个值
     *
     * @param x
     * @param key
     * @param val
     * @return
     */
    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        //放入的key应该是更新根节点,还是在左子树中,或者右子树中
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        //结点放好了之后,更新它的父节点的N(总结点数)
        x.N = size(x.left) + size(x.right) + 1;
        //这里表示层层递归返回的是本身
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        //如果大于零
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            //如果在x的右侧没找到,则返回x本身
            return x;
        }
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    //找出一个结点X,该结点size(X.left)==k
    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        //如果t大于k,就继续在左节点寻找计算
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    //在结点X下找一个左节点,该结点没有左节点,并更新X的N值
    //如果遍历到最底端则不返回X本身,而是返回X.right
    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void printAll() {
        print(root);
    }

    //print(node.left) 从当前结点一直往左找
    //找到一个结点x,然后把当前节点的左半部分打印后再打右半部分
    private void print(Node node) {
        if (node == null) {
            return;
        }
        print(node.left);
        StdOut.printf("%6s", node.val);
        print(node.right);
    }

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(50, "A50");
        bst.put(10, "A10");
        bst.put(100, "A100");
        bst.put(2, "A2");
        bst.put(30, "A30");
        bst.put(70, "A70");
        bst.put(120, "A120");
        bst.put(60, "A60");
        bst.put(15, "A15");
        bst.put(40, "A40");
        System.out.println(bst.select(7));
        //System.out.println(bst.size());
    }

}
