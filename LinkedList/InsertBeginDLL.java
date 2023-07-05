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

class InsertBeginDLL {

    public static DNode insertBegin(DNode head, int data) {
        DNode temp = new DNode(data);
        temp.next = head;
        if (head != null)
            head.prev = temp;
        return temp;
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
        head = insertBegin(head, 5);
        printlist(head);

    }
}