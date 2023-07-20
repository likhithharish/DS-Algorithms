package Trees;

import java.util.ArrayList;

public class LowestCommonAncestor {

    public static Node naiveImpl(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        if (!findPath(root, path1, n1) || !findPath(root, path2, n2)) {
            return null;
        }

        for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
            if (path1.get(i + 1) != path2.get(i + 1)) {
                return path1.get(i);
            }
        }
        if (path1.size() < path2.size()) {
            if (path1.get(path1.size() - 1).key == path2.get(path1.size() - 1).key) {
                return path1.get(path1.size() - 1);
            }
        }
        if (path2.size() < path1.size()) {
            if (path1.get(path2.size() - 1).key == path2.get(path2.size() - 1).key) {
                return path1.get(path2.size() - 1);
            }
        }
        return null;
    }

    public static boolean findPath(Node root, ArrayList<Node> path, int n) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.key == n) {
            return true;
        }
        if (findPath(root.left, path, n) || findPath(root.right, path, n)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static Node efficientImpl(Node root, Node p, Node q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        Node lca1 = efficientImpl(root.left, p, q);
        Node lca2 = efficientImpl(root.right, p, q);
        if (lca1 != null && lca2 != null) {
            return root;
        }
        if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println(efficientImpl(root, new Node(60), new Node(70)).key);
    }
}
