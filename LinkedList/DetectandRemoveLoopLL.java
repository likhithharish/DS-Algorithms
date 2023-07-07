package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class DetectandRemoveLoopLL {

    public static Node detectNremoveLoop(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // loop detected
                break;
            }
        } while (slow != fast && fast != null && fast.next != null);
        if (slow != fast) {
            return head;
        }
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
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
        Node head = new Node(10);
        Node temp = new Node(20);
        Node t1 = new Node(30);
        Node t2 = new Node(40);
        head.next = temp;
        temp.next = t1;
        t1.next = t2;
        t2.next = temp;
        head = detectNremoveLoop(head);
        printList(head); // 10 -> 20 -> 30 -> 40 ->
    }
}
