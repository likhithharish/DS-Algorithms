package Trees;

public class DiameterBinaryTree {

    public static int naiveDiameter(Node root) {
        if (root == null) {
            return 0;
        }
        int d1 = 1 + height(root.left) + height(root.right);
        int d2 = naiveDiameter(root.left);
        int d3 = naiveDiameter(root.right);
        return Math.max(d1, Math.max(d2, d3));
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int res;

    public static int efficientDiameter(Node root) {
        if (root == null) {
            return 0;
        }
        computeHeight(root);
        return res;
    }

    public static int computeHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = computeHeight(root.left);
        int rh = computeHeight(root.right);
        res = Math.max(res, 1 + lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        System.out.println(efficientDiameter(root));
    }
}
