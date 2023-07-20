package Trees;

// Construct binary tree from inOrder and PreOrder traversal
public class ConstructBinaryTree {

    public static int preIndex = 0;

    public static Node buildTree(int[] preorder, int[] inorder) {
        return cTree(preorder, inorder, 0, preorder.length - 1);
    }

    public static Node cTree(int[] preorder, int[] inorder, int is, int ie) {
        if (is > ie) {
            return null;
        }
        Node root = new Node(preorder[preIndex++]);

        int inIndex = is;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == root.key) {
                inIndex = i;
                break;
            }
        }
        root.left = cTree(preorder, inorder, is, inIndex - 1);
        root.right = cTree(preorder, inorder, inIndex + 1, ie);
        return root;
    }

    public static void printTree(Node root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.key + " ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        int[] preorder = { 10, 20, 30, 40, 50 };
        int[] inorder = { 20, 10, 40, 30, 50 };

        Node root = buildTree(preorder, inorder);
        printTree(root);

    }
}
