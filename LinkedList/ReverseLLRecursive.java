package LinkedList;

public class ReverseLLRecursive {

    public static Node recuReverse1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node rest_head = recuReverse1(head.next);
        Node rest_tail = head.next;
        head.next = null;
        rest_tail.next = head;
        return rest_head;
    }

    public static Node recuReverse2(Node curr, Node prev) {
        if (curr == null) {
            return prev;
        }
        Node next = curr.next;
        curr.next = prev;
        return recuReverse2(next, curr);
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
        head = recuReverse2(head, null);
        printList(head); // 30 -> 20 -> 10 ->
    }
}
