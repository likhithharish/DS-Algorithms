package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class InsertAnyPositionLL {

    public static Node insertAtPos(Node head, int pos, int x) {
        Node temp = new Node(x);
        if (pos == 1) {
            temp.next = head;
            return temp; // makes temp as head
        }
        Node curr = head;
        for (int i = 1; i <= pos - 2 && curr != null; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            return head;// position out of current list
        }
        temp.next = curr.next;
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
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        printList(head); // 10 -> 20 -> 30 ->
        head = insertAtPos(head, 2, 15);
        printList(head); // 10 -> 15 -> 20 -> 30 ->
        head = insertAtPos(head, 1, 5);
        printList(head); // 5 -> 10 -> 15 -> 20 -> 30 ->
        head = insertAtPos(head, 10, 5);
        printList(head); // 5 -> 10 -> 15 -> 20 -> 30 ->
    }
}
