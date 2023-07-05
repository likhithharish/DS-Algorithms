package LinkedList;

public class MiddleOfLL {
    // Given a single linked list ,
    // find the middle of the ll.

    public static void middleOfLL(Node head) {
        // Naive solution
        if (head == null) {
            return;
        }
        int count = 1;
        Node curr = head;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        curr = head;
        for (int i = 0; i < count / 2; i++) {
            curr = curr.next;
        }
        System.out.println(curr.data);
    }

    public static void middleOfLLEff(Node head) {
        // Efficient sol
        if (head == null) {
            return;
        }
        Node slow = head, fast = head;
        while (fast.next != null) {
            slow = slow.next;
            if (fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
        }
        /*
         * while(fast !=null && fast.next != null){
         * slow = slow.next;
         * fast = fast.next.next;
         * }
         */
        System.out.println("MIDDLE: " + slow.data);
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
        System.out.print("List :: ");
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 5);
        middleOfLL(head); // 5
        middleOfLLEff(head); // 5
        head = insertEnd(head, 15);
        head = insertEnd(head, 25);
        head = insertEnd(head, 30);
        printList(head); // 10 -> 5 -> 15 -> 25 -> 30 ->
        middleOfLL(head); // 15
        head = insertEnd(head, 40);
        printList(head); // 10 -> 5 -> 15 -> 25 -> 30 -> 40 ->
        middleOfLL(head);// 25
        middleOfLLEff(head); // 25
    }
}
