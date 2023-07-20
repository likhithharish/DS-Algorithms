package Trees;

import java.util.Stack;

public class IterativeInOrderTraversal {

    public static void iterativeInorder(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.add(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(1);
        root.right.right = new Node(1);

        iterativeInorder(root);
    }
}
