package Trees;

public class CountNodes {
    // Count nodes in a binary tree.

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static int effCountNodes(Node root) {
        int lh = 0, rh = 0;
        Node curr = root;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }
        if (lh == rh) {
            return (int) (Math.pow(2, lh) - 1);
        }
        return effCountNodes(root.left) + effCountNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        System.out.println(countNodes(root));
        System.out.println(effCountNodes(root));
    }
}
