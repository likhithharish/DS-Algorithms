package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class InsertBeginLL {
    public static Node insertBegin(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }

    public static void printList(Node n) {

        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertBegin(head, 10);
        head = insertBegin(head, 5);
        head = insertBegin(head, 15);
        printList(head); // 15 -> 5 -> 10
    }
}
