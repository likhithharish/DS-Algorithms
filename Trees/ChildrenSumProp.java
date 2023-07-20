package Trees;

public class ChildrenSumProp {

    public static boolean checkChildSum(Node root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null
                && root.left.key + root.right.key != root.key) {
            return false;
        } else if (root.left != null && root.right == null
                && root.left.key != root.key) {
            return false;
        } else if (root.left == null && root.right != null
                && root.right.key != root.key) {
            return false;
        }
        boolean l = checkChildSum(root.left);
        boolean r = checkChildSum(root.right);
        return (l && r);
    }

    public static boolean betterImpl(Node root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        int sum = 0;
        if (root.left != null) {
            sum += root.left.key;
        }
        if (root.right != null) {
            sum += root.right.key;
        }
        return (root.key == sum && betterImpl(root.left) && betterImpl(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(1);
        root.right.right = new Node(1);
        System.out.println(checkChildSum(root));
        System.out.println(betterImpl(root));
    }

}
