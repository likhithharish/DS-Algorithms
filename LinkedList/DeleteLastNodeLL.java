package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class DeleteLastNodeLL {
    public static Node deleteEnd(Node head) {
        if (head == null) {
            // No elem in linked list.
            return null;
        }
        if (head.next == null) {
            // only head in linked list.
            return null;
        }
        Node curr = head;
        Node prev = curr;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        /*
         * another way
         * while(curr.next.next != null){
         * curr = curr.next;
         * }
         * curr.next = null;
         */
        prev.next = null;
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
        System.out.print("Current List: ");
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
        printList(head); // 10 -> 20 -> 30 -> 40 ->
        head = deleteEnd(head);
        printList(head); // 10 -> 20 -> 30 ->
        head = deleteEnd(head);
        printList(head); // 10 -> 20 ->
        head = deleteEnd(head);
        printList(head);// 10 ->
        head = deleteEnd(head);
        printList(head); // {null}
        head = deleteEnd(head);
        printList(head); // {null}
    }
}
