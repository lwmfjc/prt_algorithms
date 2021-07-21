package com.ly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution589 {
    public void preorder1(List<Integer> list, Node node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.children == null) {
            return;
        }
        for (int i = 0; i < node.children.size(); i++) {
            preorder1(list, node.children.get(i));
        }
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder1(list, root);
        return list;
    }


    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        List<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            Node cur = stack.peek();
            stack.pop();
            if (cur != null) {
                list.add(cur.val);
                if (cur.children != null) {
                    int n = cur.children.size();
                    for (int i = n - 1; i >= 0; i--) {
                        if (cur.children.get(i) != null) {
                            stack.push(cur.children.get(i));
                        }
                    }
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        List<Node> rootChild = new ArrayList<>();
        Node nodeRc1 = new Node(3);
        Node nodeRc2 = new Node(2);
        Node nodeRc3 = new Node(4);
        rootChild.add(nodeRc1);
        rootChild.add(nodeRc2);
        rootChild.add(nodeRc3);
        Node root = new Node(1, rootChild);
        List<Node> rc1Rc = new ArrayList<>();
        rc1Rc.add(new Node(5));
        rc1Rc.add(new Node(6));
        nodeRc1.children = rc1Rc;
        final List<Integer> preorder = new Solution589().preorder(root);
        for (Integer i : preorder) {
            System.out.print(i);
        }
    }
}
