package LinkedList;

class DNode {
    int data;
    DNode next;
    DNode prev;

    DNode(int x) {
        data = x;
    }
}

public class CircularDoubleLL {

    public static DNode insertBeginCDL(DNode head, int x) {
        DNode temp = new DNode(x);
        if (head == null) {
            temp.next = temp;
            temp.prev = temp;
            return temp;
        }
        temp.prev = head.prev; // mark temp prev to last node
        temp.next = head; // mark temp next to head node
        head.prev.next = temp;// mark last node next to temp
        head.prev = temp; // mark head node prev to temp
        return temp;
    }

    public static void printlist(DNode head) {
        if (head == null)
            return;
        DNode r = head;
        do {
            System.out.print(r.data + " -> ");
            r = r.next;
        } while (r != head);
        System.out.println("");
    }

    public static void main(String[] args) {
        DNode head = null;
        head = insertBeginCDL(head, 10);
        printlist(head); // 10 ->
        head = insertBeginCDL(head, 15);
        head = insertBeginCDL(head, 20);
        head = insertBeginCDL(head, 30);
        printlist(head); // 30 -> 20 -> 15 -> 10 ->
    }
}
