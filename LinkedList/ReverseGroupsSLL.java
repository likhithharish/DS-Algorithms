package LinkedList;

public class ReverseGroupsSLL {
    // Reverse LL node in groups of k
    public static Node reverseInGroupsRec(Node head, int k) {
        Node prev = null;
        Node next = null;
        Node curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            next = curr.next;// save next node
            curr.next = prev; // mark curr next to prev node
            prev = curr; // move prev ref to curr node
            curr = next;// move curr ref to next node
        }
        if (next != null) {
            Node rest_head = reverseInGroupsRec(next, k);
            head.next = rest_head;
        }
        return prev;
    }

    public static Node reverseInGroupsIter(Node head, int k) {
        Node curr = head, prevFirst = null;
        boolean firstPass = true;
        while (curr != null) {
            Node first = curr, prev = null;
            int count = 0;
            while (count < k && curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (firstPass) {
                head = prev;
                firstPass = false;// set head for first k pass only
            } else {
                prevFirst.next = prev;
            }
            prevFirst = first;
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
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        head = insertEnd(head, 50);
        printList(head); // 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> 70 ->
        head = reverseInGroupsIter(head, 3);
        printList(head); // 30 -> 20 -> 10 -> 60 -> 50 -> 40 -> 70 ->
    }
}
