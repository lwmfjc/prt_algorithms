package com.ly.ch3_exp;

import com.ly.ch3.ISearch;
import edu.princeton.cs.algs4.StdOut;

public class BST<Key extends Comparable<Key>, Value> implements ISearch<Key, Value> {
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
    //★这个递归正常情况下传入x返回x,但是如果x为空,则返回新结点
    public Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //★这里翻译一下就是对x.right进行判断,要么更新要么拿新结点填上
            //根据下一个递归函数,if x.right == null则返回新节点
            //if x.right.key == x.key 则停止递归
            //★这里传入什么都返回什么,注意看下面return x;
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

    //往左节点一直找,直到x.left==null,返回x
    private Node min(Node x) {
        //这个条件就不是if x== null,原因是如果这样的话,
        // 就没法返回上一个

        /*
        if (x == null) return null;
        //★这里传入什么都返回结果[注意下面return node]
        //★而且返回的是最后一次递(归)的结果
        Node node = min(x.left);
        if (node == null) {
            return x;
        }
        //如果是这个写法,那么每一层(递)归都会返回倒数第二层的结果
        return node;
       */
        if (x.left == null) return x;
        //其实这里跟上面的代码是一样的,也只返回最后一次进递(归)返回的结果
        return min(x.left);
    }

    //小于等于key的key
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    @Override
    public Key ceil(Key key) {
        Node x = ceil(root, key);
        if (x == null) return null;
        return x.key;
    }

    //大于等于key的最小值
    //即从x的右侧找
    private Node ceil(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp < 0) {
            Node t = ceil(x.left, key);
            if (t == null) {
                return x;
            } else {
                return t;
            }

        } else {
            return ceil(x.right, key);
        }
    }

    //小于等于key的最大值
    //即从x的左侧找
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

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
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

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        //除了x==null,其他情况都要返回自身
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            //如果两个都不为空
            //从右子树中找到最小的值充当根节点
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    public void printAll() {
        print(root);
    }
    //print(node.left) 从当前结点一直往左找
    //找到一个结点x,然后把当前节点的左半部分打印后再打右半部分
    private void print( Node node) {
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
        bst.put(120, "A120");
        bst.put(110, "A110");
        bst.put(80, "A80");
        bst.put(65, "A65");
        bst.delete(140);
        bst.printAll();
        //StdOut.print(bst.ceil(88));
        // System.out.println(bst.max());
    }

}
