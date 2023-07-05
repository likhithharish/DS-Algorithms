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

public class DoubleLinkedList {
    public static void main(String[] args) {
        DNode head = new DNode(1);
        DNode temp1 = new DNode(2);
        DNode temp2 = new DNode(3);
        head.prev = null;
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
    }
}
