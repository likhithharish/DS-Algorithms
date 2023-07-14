package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumOfBinaryTree {

    public static int maximum(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int l = maximum(root.left);
        int r = maximum(root.right);
        int val = Math.max(l, r);
        return Math.max(root.key, val);
    }

    public static int maxLevelOrder(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (curr != null) {
                    max = Math.max(curr.key, max);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println(maxLevelOrder(root));
    }
}
