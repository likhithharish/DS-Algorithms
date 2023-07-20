package Trees;

import java.util.*;

/**
 * MaximumWidthofBinaryTree
 */
public class MaximumWidthofBinaryTree {

    public static int maximumWidth(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res = Math.max(res, size);
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.left.left = new Node(80);
        root.right = new Node(30);
        root.right.left = new Node(50);
        root.right.right = new Node(60);
        System.out.println(maximumWidth(root));
    }
}