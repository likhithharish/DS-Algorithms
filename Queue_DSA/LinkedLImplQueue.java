package Queue_DSA;

class Node {
    int data;
    Node next;

    Node(int x) {
        this.data = x;
    }
}

// Single linked list with tail reference;
class LLQueue {
    private Node head, tail;
    private int size;

    public LLQueue() {
        head = null;
        tail = head;
        size = 0;
    }

    public void enqueue(int x) {
        Node temp = new Node(x);
        if (head == null) {
            head = temp;
            tail = head;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public int dequeue() {
        if (head == null) {
            return -1;
        }
        Node curr = head;
        head = head.next;
        size--;
        return curr.data;
    }

    public int size() {
        return size;
    }

    public int getFront() {
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    public int getRear() {
        if (head == null) {
            return -1;
        }
        return tail.data;
    }
}

public class LinkedLImplQueue {
    public static void main(String[] args) {
        LLQueue q = new LLQueue();
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println("Front:" + q.getFront());// 2
        System.out.println("Rear:" + q.getRear());// 4
        System.out.println("Removing :" + q.dequeue());// 2 removed
        System.out.println("Front:" + q.getFront());// 3
        System.out.println("Rear:" + q.getRear());// 4
        q.enqueue(5);
        q.enqueue(6);
        System.out.println("Front:" + q.getFront());// 3
        System.out.println("Rear:" + q.getRear());// 6
        System.out.println("Removing :" + q.dequeue());// 3 removed
        System.out.println("Removing :" + q.dequeue()); // 4 removed
        q.enqueue(1);
        System.out.println("Front:" + q.getFront());// 5
        System.out.println("Rear:" + q.getRear());// 1

    }
}
