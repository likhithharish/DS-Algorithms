package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class SearchSingleLL {

    public static int searchLL(Node head, int x) {
        // Iterative sol
        int pos = 1;
        Node curr = head;
        while (curr.next != null) {
            if (curr.data == x) {
                return pos;
            } else {
                pos++;
                curr = curr.next;
            }
        }
        if (curr.data == x) {
            // is x is at last node
            return pos;
        }
        return -1;
    }

    public static int searchRecLL(Node head, int x, int currPos) {
        if (head.data == x) {
            return currPos;
        }
        if (head.next == null) {
            return -1;
        }
        return searchRecLL(head.next, x, currPos + 1);
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
        System.out.print("Current List: ");
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
        head = insertEnd(head, 40);
        printList(head); // 10 -> 20 -> 30 -> 40 ->
        System.out.println(searchLL(head, 50)); // -1
        System.out.println(searchLL(head, 40)); // 4
        System.out.println(searchLL(head, 10)); // 1
        System.out.println(searchRecLL(head, 50, 1)); // -1
        System.out.println(searchRecLL(head, 40, 1)); // 4
        System.out.println(searchRecLL(head, 30, 1)); // 3
        System.out.println(searchRecLL(head, 10, 1)); // -1
    }
}
