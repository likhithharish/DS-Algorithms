package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftView {
    // given a binary tree , print leftmost node at every level
    public static int maxLevel = 0;

    public static void printLevelEff(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.print(root.key + " ");
            maxLevel = level;
        }
        printLevelEff(root.left, level + 1);
        printLevelEff(root.right, level + 1);
    }

    public static void printLevelRec(Node root) {
        printLevelEff(root, 1);
        System.out.println("");
    }

    public static void printLeftIter(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean isFirst = true;
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (isFirst) {
                    System.out.print(curr.key + " ");
                    isFirst = false;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            isFirst = true;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        // root.left = new Node(50);
        // root.right = new Node(60);
        // root.right.left = new Node(70);
        // root.right.right = new Node(20);
        // root.right.left.right = new Node(8);
        root.right = new Node(50);
        root.right.left = new Node(60);
        root.right.left.right = new Node(10);

        printLeftIter(root);// 10 50 70 8
        printLevelRec(root);
    }
}
