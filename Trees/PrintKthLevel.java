package Trees;

public class PrintKthLevel {
    // Given a binary tree, print all nodes
    // that are k distance from the root.
    public static void printNodes(Node root, int k) {
        if (root != null) {
            if (k == 0) {
                System.out.print(root.key + " ");
            }
            printNodes(root.left, k - 1);
            printNodes(root.right, k - 1);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right = new Node(30);
        root.right.right = new Node(70);

        printNodes(root, 2); // 40 50 70
    }
}
