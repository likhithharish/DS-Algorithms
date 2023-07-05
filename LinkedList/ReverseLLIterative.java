package LinkedList;

import java.util.ArrayList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class ReverseLLIterative {

    public static Node reverseLL(Node head) {
        // Using auxilary space
        ArrayList<Integer> list = new ArrayList<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            list.add(curr.data);
        }
        for (Node curr = head; curr != null; curr = curr.next) {
            curr.data = list.remove(list.size() - 1);
        }
        return head;
    }

    public static Node effReverseLL(Node head) {
        // Change the links
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;// save next node
            curr.next = prev; // mark curr next to prev node
            prev = curr; // move prev ref to curr node
            curr = next;// move curr ref to next node
        }
        return prev;// new head
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
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        printList(head); // 10 -> 20 -> 30 ->
        // head = reverseLL(head);
        // printList(head);// 30 -> 20 -> 10 ->
        head = effReverseLL(head);
        printList(head); // 30 -> 20 -> 10 ->
    }

}
