package LinkedList;

import java.util.HashSet;

public class DetectLoop {
    public static boolean detectLoop(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        } while (slow != fast && fast != null && fast.next != null);
        return false;
    }

    public static boolean detectLoop2(Node head) {
        // Changing pointers/ reference
        Node temp = new Node(0);
        Node curr = head;
        while (curr != null) {
            if (curr.next == null) {
                return false;
            }
            if (curr.next == temp) {
                return true;
            }
            Node next = curr.next;
            curr.next = temp;
            curr = next;
        }
        return false;
    }

    public static boolean detectLoopHash(Node head) {
        HashSet<Node> s = new HashSet<Node>();
        for (Node curr = head; curr != null; curr = curr.next) {
            if (s.contains(curr))
                return true;
            s.add(curr);
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = new Node(20);
        Node t1 = new Node(30);
        Node t2 = new Node(40);
        head.next = temp;
        temp.next = t1;
        t1.next = t2;
        t2.next = temp;
        // System.out.println(detectLoop(head));
        // System.out.println(detectLoop2(head));
        System.out.println(detectLoopHash(head));
    }
}
