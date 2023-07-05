package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class CircularSingleLL {
    // INSERT AT BEGIN
    public static Node insertBegin(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        }
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.next = head;
        return temp;
    }

    public static Node insertBeginEff(Node head, int x) {
        // Effective O(1)
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        } else {
            temp.next = head.next;
            head.next = temp;
            int t = head.data;
            head.data = temp.data;
            temp.data = t;
            return head;
        }
    }

    // INSERT AT END
    public static Node insertEnd(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        }
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.next = head;
        return head;
    }

    public static Node insertEndEff(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        } else {
            temp.next = head.next;
            head.next = temp;
            int t = head.data;
            head.data = temp.data;
            temp.data = t;
            return temp;
        }
    }

    // DELETE HEAD
    public static Node deleteHeadNaive(Node head) {
        if (head == null || head.next == head) {
            return null;
        }
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = head.next;
        return head.next;
    }

    public static Node deleteHeadEff(Node head) {
        if (head == null || head.next == head) {
            return null;
        }
        Node temp = head.next;
        int t = temp.data;
        temp.data = head.data;
        head.data = t;
        head.next = temp.next;
        return head;
    }

    // Delete Kth Position
    public static Node deleteKthNode(Node head, int k) {
        int pos = 1;
        if (k == 1) {
            head = deleteHeadEff(head);
            return head;
        }
        Node curr = head;
        Node prev = null;
        while (curr.next != head) {
            pos++;
            prev = curr;
            curr = curr.next;
            if (pos == k) {
                break;
            }
        }
        prev.next = curr.next;
        return head;
    }

    public static Node deleteKthNode2(Node head, int k) {
        if (head == null)
            return head;
        if (k == 1)
            return deleteHeadEff(head);
        Node curr = head;
        for (int i = 0; i < k - 2; i++)
            curr = curr.next;
        curr.next = curr.next.next;
        return head;
    }

    // TRAVERSING LIST
    public static void printList(Node head) {
        if (head == null) {
            return;
        }
        if (head.next == head) {
            System.out.print(head.data + " -> ");
            System.out.println("");
            return;
        }
        Node curr = head;
        while (curr.next != head) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print(curr.data + " -> ");
        System.out.println("");
    }

    public static void effprintlist(Node head) {
        // Traverse effectively with for loop
        if (head == null)
            return;
        System.out.print(head.data + " -> ");
        for (Node r = head.next; r != head; r = r.next)
            System.out.print(r.data + " -> ");
        System.out.println("");
    }

    public static void effprintlist2(Node head) {
        // Traverse effectively using do-while
        if (head == null)
            return;
        Node r = head;
        do {
            System.out.print(r.data + " ");
            r = r.next;
        } while (r != head);
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = head; // circular
        printList(head); // 10 -> 20 -> 30 ->
        head = insertBegin(head, 40);
        printList(head); // 40 -> 10 -> 20 -> 30 ->
        head = insertEnd(head, 50);
        printList(head); // 40 -> 10 -> 20 -> 30 -> 50 ->
        head = insertBeginEff(head, 5);
        effprintlist(head); // 5 -> 40 -> 10 -> 20 -> 30 -> 50 ->
        head = insertEndEff(head, 70);
        printList(head); // 5 -> 40 -> 10 -> 20 -> 30 -> 50 -> 70 ->
        head = deleteHeadNaive(head);
        printList(head); // 40 -> 10 -> 20 -> 30 -> 50 -> 70 ->
        head = deleteHeadEff(head);
        printList(head);// 10 -> 20 -> 30 -> 50 -> 70 ->
        head = deleteKthNode(head, 2);
        printList(head); // 10 -> 30 -> 50 -> 70 ->
        head = deleteKthNode(head, 1);
        printList(head);// 30 -> 50 -> 70 ->
    }
}
