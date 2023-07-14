package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void levelOrder(Node root) {
        int height = height(root);

        for (int i = 0; i < height; i++) {
            printNodes(root, i);
        }
    }

    public static void printNodes(Node root, int k) {
        if (root != null) {
            if (k == 0) {
                System.out.print(root.key + " ");
            }
            printNodes(root.left, k - 1);
            printNodes(root.right, k - 1);
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void efficient(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.key + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right = new Node(30);
        root.right.right = new Node(70);

        efficient(root);// 10 20 30 40 50 70
    }
}
