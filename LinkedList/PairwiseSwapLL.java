package LinkedList;

public class PairwiseSwapLL {

    public static void pairWiseSwap(Node head) {
        // Changing data
        Node curr = head;
        while (curr != null && curr.next != null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }
    }

    public static Node changingLinks(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curr = head.next.next;
        Node prev = head;
        // process first two nodes first.
        head = head.next;
        head.next = prev;
        // handle rest of nodes
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            Node next = curr.next.next;
            (curr.next).next = curr;
            curr = next;
        }
        prev.next = curr;
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
        head = insertEnd(head, 5);
        head = insertEnd(head, 15);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        printList(head); // 10 -> 5 -> 15 -> 20 -> 30 ->
        head = changingLinks(head);
        printList(head);// 5 -> 10 -> 20 -> 15 -> 30 ->
    }
}
