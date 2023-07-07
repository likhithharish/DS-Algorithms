package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class RemoveDupsSortedLL {
    // Remove duplicates from a sorted Linked list

    public static Node removeDups(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (prev.data == curr.data) {
                Node next = curr.next;
                prev.next = next;
                curr = next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
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
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 30);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        printList(head); // 10 -> 20 -> 20 -> 30 -> 30 -> 30 -> 40 ->
        head = removeDups(head);
        printList(head); // 10 -> 20 -> 30 -> 40 ->
    }
}
