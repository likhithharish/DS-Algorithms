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

public class InsertEndDLL {

    public static DNode insertEnd(DNode head, int x) {
        DNode temp = new DNode(x);
        if (head == null) {
            return head;
        }
        DNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
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

    public static void main(String args[]) {
        DNode head = new DNode(10);
        DNode temp1 = new DNode(20);
        DNode temp2 = new DNode(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
        printlist(head); // 10 -> 20 -> 30 ->
        head = insertEnd(head, 5);
        printlist(head); // 10 -> 20 -> 30 -> 5 ->

    }
}
