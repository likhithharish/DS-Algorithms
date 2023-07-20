package Trees;

import java.util.Stack;

public class IterativePreOrderTraversal {

    public static void naiveIterSol(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()) {
            Node curr = st.pop();
            System.out.print(curr.key + " ");
            if (curr.right != null) {
                st.add(curr.right);
            }
            if (curr.left != null) {
                st.add(curr.left);
            }
        }
    }

    public static void effiSol(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        Node curr = root;
        st.add(root);
        while (curr != null && !st.isEmpty()) {
            while (curr != null) {
                System.out.print(curr.key + " ");
                if (curr.right != null) {
                    st.push(curr.right);
                }
                curr = curr.left;
            }
            if (!st.isEmpty()) {
                curr = st.pop();
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(1);
        root.right.right = new Node(1);

        naiveIterSol(root);
        System.out.println("");
        effiSol(root);
    }
}
