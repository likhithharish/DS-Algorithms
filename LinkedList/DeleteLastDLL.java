package LinkedList;

class DNode {
    int data;
    DNode prev;
    DNode next;

    DNode(int d) {
        data = d;
        prev = null;
        next = null;
    }
}

public class DeleteLastDLL {

    public static DNode deleteLast(DNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        DNode curr = head;
        DNode previous = null;
        while (curr.next != null) {
            previous = curr;
            curr = curr.next;
        }
        previous.next = null;
        curr.prev = null;
        // or single line - curr.prev.next = null;
        return head;
    }

    public static void printlist(DNode head) {
        DNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DNode head = new DNode(10);
        DNode temp1 = new DNode(20);
        DNode temp2 = new DNode(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
        printlist(head);// 10 -> 20 -> 30 ->
        head = deleteLast(head);
        printlist(head);// 10 -> 20 ->
        head = deleteLast(head);
        printlist(head);// 10 ->
        head = deleteLast(head);
        printlist(head);// {null}
    }
}
