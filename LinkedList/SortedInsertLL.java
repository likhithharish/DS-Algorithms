package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
    }
}

public class SortedInsertLL {
    // Insert node in sorted LL

    public static Node insertSorted(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            return temp;
        }
        if (head.data > x) {
            temp.next = head;
            return temp;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data > x || curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    public static Node insertEnd(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            return temp;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        printList(head); // 10 -> 20 -> 30 ->
        head = insertSorted(head, 15);
        printList(head);// 10 -> 15 -> 20 -> 30 ->
        head = insertSorted(head, 5);
        printList(head); // 5 -> 10 -> 15 -> 20 -> 30 ->
        head = insertSorted(head, 50);
        printList(head); // 5 -> 10 -> 15 -> 20 -> 30 -> 50 ->
    }
}
