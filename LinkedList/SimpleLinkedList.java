package LinkedList;

class Node {
    int data;
    Node next;

    // Constructor for Node class
    Node(int x) {
        data = x;
        next = null;
    }
}

public class SimpleLinkedList {
    // Simple Linked List of 3 nodes - Implementation in java
    public static void main(String[] args) {
        Node head = new Node(3);
        Node temp1 = new Node(20);
        Node temp2 = new Node(15);
        head.next = temp1;
        temp1.next = temp2;
    }
}
