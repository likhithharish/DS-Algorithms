package Trees;

public class BalancedTree {
    // Check if tree is height balanced.
    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static boolean isBalancedEff(Node root) {
        int val = checkBalance(root);
        return (val != -1);
    }

    public static int checkBalance(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = checkBalance(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = checkBalance(root.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(18);
        root.left = new Node(4);
        root.right = new Node(20);
        root.right.left = new Node(13);
        root.right.right = new Node(70);

    }
}
