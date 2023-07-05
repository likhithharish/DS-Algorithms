package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class FindNthNodefromEnd {
    // Find nth node from the end in single linked list

    public static void nthNodeFromEnd(Node head, int n) {
        if (head == null) {
            return;
        }
        int count = 1;
        Node curr = head;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        int pos = 1;
        int k = count - n + 1;
        curr = head;
        while (curr.next != null) {
            if (pos == k) {
                break;
            }
            pos++;
            curr = curr.next;
        }
        System.out.println("ANSWER: " + curr.data);
    }

    public static void nthNode2(Node head, int n) {
        if (head == null) {
            return;
        }
        Node first = head;
        for (int i = 0; i < n; i++) {
            if (first == null) {
                return;
            }
            first = first.next;
        }
        Node second = head;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        System.out.println("SECOND WAY ANSWER: " + second.data);
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
        head = insertEnd(head, 40);
        head = insertEnd(head, 50);
        head = insertEnd(head, 60);
        printList(head); // 10 -> 20 -> 30 -> 40 -> 50 -> 60 ->
        nthNodeFromEnd(head, 6); // 10
        nthNode2(head, 1); // 60
    }
}
