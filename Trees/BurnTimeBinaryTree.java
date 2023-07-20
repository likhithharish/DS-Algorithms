package Trees;

class Distance {
    int val;

    Distance(int k) {
        val = k;
    }
}

public class BurnTimeBinaryTree {
    // given a leaf in a binary tree, compute time taken
    // to burn the tree starting from leaf adjacents

    public static int res = 0;

    public static int burnTime(Node root, int leaf, Distance dist) {
        if (root == null)
            return 0;
        if (root.key == leaf) {
            dist.val = 0;
            return 1;
        }
        Distance ldist = new Distance(-1), rdist = new Distance(-1);
        int lh = burnTime(root.left, leaf, ldist);
        int rh = burnTime(root.right, leaf, rdist);

        if (ldist.val != -1) {
            dist.val = ldist.val + 1;
            res = Math.max(res, dist.val + rh);
        } else if (rdist.val != -1) {
            dist.val = rdist.val + 1;
            res = Math.max(res, dist.val + lh);
        }
        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.left.left = new Node(60);
        root.left.left.left.left = new Node(70);
        Distance dist = new Distance(-1);
        int leaf = 50;

        burnTime(root, leaf, dist);
        System.out.print(res);
    }
}
