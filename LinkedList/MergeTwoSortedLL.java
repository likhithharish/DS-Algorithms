package LinkedList;

public class MergeTwoSortedLL {
    public static Node sortedMerge(Node head1, Node head2) {
        Node head = null, tail = null;
        if (head1 == null && head2 != null) {
            return head2;
        }
        if (head1 != null && head2 == null) {
            return head1;
        }
        if (head1.data > head2.data) {
            head = head2;
            tail = head2;
            head2 = head2.next;
        } else {
            head = head1;
            tail = head1;
            head1 = head1.next;
        }
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }

        // Add rest to the tail
        if (head1 == null) {
            tail.next = head2;
        } else {
            tail.next = head1;
        }

        return head;
    }

    public static void printlist(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        a.next = new Node(20);
        a.next.next = new Node(30);
        Node b = new Node(5);
        b.next = new Node(35);
        printlist(sortedMerge(a, b));
    }
}
