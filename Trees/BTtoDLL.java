package Trees;

class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;

    DLLNode(int x) {
        data = x;
    }
}

// convert binary tree to Doubly LinkedList
// Using inorder traversal.
public class BTtoDLL {

    public static DLLNode head, curr;

    public static void convert(Node root) {
        if (root != null) {
            convert(root.left);
            DLLNode temp = new DLLNode(root.key);
            if (head == null) {
                head = temp;
                curr = head;
            } else {
                curr.next = temp;
                temp.prev = curr;
                curr = temp;
            }
            System.out.print(root.key + " ");
            convert(root.right);
        }
    }

    public static void printList(DLLNode head) {
        DLLNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("");
    }

    public static Node prev;

    public static Node inPlaceConvert(Node root) {
        if (root == null) {
            return root;
        }
        Node head = inPlaceConvert(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        inPlaceConvert(root.right);
        return head;
    }

    public static void printTreeAsList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.key + " -> ");
            curr = curr.right;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.left.left = new Node(80);
        root.right = new Node(30);
        root.right.left = new Node(50);
        root.right.right = new Node(60);

        Node head = inPlaceConvert(root);
        printTreeAsList(head); // 80 -> 40 -> 20 -> 10 -> 50 -> 30 -> 60 ->
        // convert(root);// 80 40 20 10 50 30 60
        // System.out.println("");
        // printList(head);// 80 -> 40 -> 20 -> 10 -> 50 -> 30 -> 60 ->
    }
}
