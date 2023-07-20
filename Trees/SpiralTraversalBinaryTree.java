package Trees;

import java.util.*;

public class SpiralTraversalBinaryTree {
    // traverse tree in spiral way - zigzag

    public static void spiralTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (count % 2 == 0) {
                    System.out.print(curr.key + " ");
                } else {
                    st.push(curr.key);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (count % 2 != 0) {
                while (!st.isEmpty()) {
                    System.out.print(st.pop() + " ");
                }
            }
            count++;
        }
        System.out.println("");
    }

    public static void method2(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.add(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node curr = s1.pop();
                System.out.print(curr.key + " ");
                if (curr.left != null) {
                    s2.add(curr.left);
                }
                if (curr.right != null) {
                    s2.add(curr.right);
                }
            }

            while (!s2.isEmpty()) {
                Node curr = s2.pop();
                System.out.print(curr.key + " ");
                // add in reverse to s1.
                if (curr.right != null) {
                    s1.add(curr.right);
                }
                if (curr.left != null) {
                    s1.add(curr.left);
                }
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        // spiralTraversal(root);// 10 30 20 40 50 60 70
        method2(root);// 10 30 20 40 50 60 70
    }
}
