package LinkedList;

public class RemoveNodeWithPointer {
    // given a single linked list , remove the node based on given pointer ( not
    // head)

    public static void deleteNode(Node node) {
        Node curr = node;
        Node prev = null;
        while (curr.next != null) {
            // Swap
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            // mark prev and change curr to next
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = new Node(20);
        Node t1 = new Node(30);
        Node t2 = new Node(40);
        head.next = temp;
        temp.next = t1;
        t1.next = t2;
        printList(head);// 10 -> 20 -> 30 -> 40 ->
        deleteNode(t1);
        printList(head); // 10 -> 20 -> 40 ->
    }
}
