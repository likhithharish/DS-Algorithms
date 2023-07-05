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

public class DeleteHeadDLL {
    // Delete Head of DLL

    public static DNode deleteHead(DNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            head = null;
            return head;
        }
        head = head.next;
        head.prev = null;
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
        head = deleteHead(head);
        printlist(head);// 20 -> 30 ->
    }

}
