package LinkedList;

public class SegregateEvenOddNodes {

    public static Node segregateEvenOdd(Node head) {
        Node temp = new Node(0);
        Node curr = head;
        Node teMNex = temp;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (temp.data == 0) {
                    temp.data = curr.data;
                } else {
                    Node t = new Node(curr.data);
                    teMNex.next = t;
                    teMNex = t;
                }

            }
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.data % 2 != 0) {
                if (temp.data == 0) {
                    temp.data = curr.data;
                } else {
                    Node t = new Node(curr.data);
                    teMNex.next = t;
                    teMNex = t;
                }
            }
            curr = curr.next;

        }
        return temp;
    }

    public static Node naiveImpl(Node head) {
        // 17 -> 15 -> 8 -> 12 -> 5 ->
        Node last = null;
        Node curr = head;
        Node lastButOne = null;
        while (curr.next != null) {
            lastButOne = curr;
            curr = curr.next;
        }
        last = curr;
        curr = head;
        while (curr.data != lastButOne.data) {
            if (curr.data % 2 != 0) {

            }
        }
        return head;
    }

    public static Node segregate(Node head) {
        Node eS = null, eE = null, oS = null, oE = null;
        for (Node curr = head; curr != null; curr = curr.next) {
            int x = curr.data;
            if (x % 2 == 0) {
                if (eS == null) {
                    eS = curr;
                    eE = eS;
                } else {
                    eE.next = curr;
                    eE = eE.next;
                }
            } else {
                if (oS == null) {
                    oS = curr;
                    oE = oS;
                } else {
                    oE.next = curr;
                    oE = oE.next;
                }
            }
        }
        if (oS == null || eS == null)
            return head;
        eE.next = oS;
        oE.next = null;
        return eS;
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
        head = insertEnd(head, 17);
        head = insertEnd(head, 15);
        head = insertEnd(head, 8);
        head = insertEnd(head, 12);
        head = insertEnd(head, 5);
        printList(head);// 17 -> 15 -> 8 -> 12 -> 5 ->
        head = naiveImpl(head);
        printList(head); // 8 -> 12 -> 17 -> 15 -> 5 ->
    }
}
