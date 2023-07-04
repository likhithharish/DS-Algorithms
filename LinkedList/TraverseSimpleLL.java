package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

}

public class TraverseSimpleLL {
    public static void printList(Node n) {

        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(10);
        head.next.next = new Node(20);
        head.next.next.next = new Node(15);
        printList(head);
    }
}
