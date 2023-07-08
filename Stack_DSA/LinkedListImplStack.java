package Stack_DSA;

class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
    }
}

class LLStack {
    private Node head;
    private int size;

    LLStack() {
        head = null;
        size = 0;
    }

    void push(int x) {
        if (head == null) {
            head = new Node(x);
        } else {
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
        }
        size += 1;
    }

    int pop() {
        int res = head.val;
        if (head.next == null) {
            head = null;
        } else {
            Node next = head.next;
            head.next = null;
            head = next;
        }
        size -= 1;
        return res;
    }

    int peek() {
        return (head == null) ? -1 : head.val;
    }

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        return size;
    }

}

public class LinkedListImplStack {
    public static void main(String[] args) {
        LLStack s = new LLStack();
        s.push(1);
        s.push(2);
        System.out.println("Top: " + s.peek() + " | Size: " + s.size());// 2|2
        s.pop();
        System.out.println("Top: " + s.peek() + " | Size: " + s.size());// 1|1
        s.push(3);
        s.push(4);
        s.pop();
        System.out.println("Top: " + s.peek() + " | Size: " + s.size());// 3|2
        System.out.println(s.isEmpty());// false
        System.out.println(s.size());// false
    }
}
