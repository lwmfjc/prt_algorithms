package com.ly.ch3_exp;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;//以该结点为根的子树中的结点的结点总数

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }

    public int size() {
        return size(root);
    }

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

    //从x结点开始查找key,存在则返回value,不存在返回null
    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //如果比根节点大,从右节点查找key
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    //先从只有一个结点开始
    //副作用:要么更新节点,要么生成节点
    //返回值：更新的结点或者新生成的结点作为上一个查找节点的子节点

    //在节点x的子节点下适当位置更新结点(找到更新,没找到生成)
    //★用来更新搜索路径上的结点的值/的子节点
    public Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //★这里翻译一下就是对x.right进行判断,要么更新要么拿新结点填上
            //根据下一个递归函数,if x.right == null则返回新节点
            //if x.right.key == x.key 则停止递归
            x.right = put(x.right, key, val);
        } else if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else {
            x.val = val;
            //return x; 我觉得这里是可以直接return的,反正又不需要更新计数器
        }

        //★这里是副作用,不是主要代码
        //这个能更新的原因是因为方法栈后进先出,所以先更新了(最)底层结点的N值
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    //往左节点一直找,直到x.left==null,返回x
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    //小于等于key的key
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        //往左找如果是空,那就是不存在
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return floor(x.left, key);
        } else if (cmp == 0) {
            return x;
        } else {//往右节点找
            Node t = floor(x.right, key);
            if (t == null) {//右节点如果没找到,那么根节点就是所求
                return x;
            } else {
                return t;
            }
        }
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    //在结点x之下查找排名为k的结点
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) {
            //在左节点查询排名为k的结点
            return select(x.left, k);
        } else if (t < k) {
            //在右节点查询排名为k-t-1的结点
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    //在某个结点下计算Node x的排名,size(x.left)就是它的排名
    private int rank(Node x, Key key) {

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return size(x.left);
        } else if (cmp < 0) {
            return rank(x.left, key);
        } else {
            //要在右边找了
            return 1 + size(x.left) + rank(x.right, key);
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    //在某个结点下查找(没有左节点的结点),
    //如果没找到则返回原结点,找到则返回该结点的右节点
    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        //如果一个结点的左节点的左节点为空,
        //则该结点指向这个结点的右节点
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    public static void main(String[] args) {

    }

}
