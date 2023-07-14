package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTree {

    public static int recSize(Node root) {
        if (root == null) {
            return 0;
        }
        return recSize(root.left) + recSize(root.right) + 1;
    }

    public static int sizeOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr != null) {
                count++;
            }
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println(sizeOfBinaryTree(root)); // 7
        System.out.println(recSize(root));// 7
    }
}
