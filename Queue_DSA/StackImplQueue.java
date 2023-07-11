package Queue_DSA;

import java.util.*;

class MyStack {
    Queue<Integer> q1, q2;
    private int size;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        size = 0;
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;// emptying q2 and adding all back to q1
        size++;
    }

    public int pop() {
        int res = q1.remove();
        size--;
        return res;
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return (size == 0);
    }
}

public class StackImplQueue {
    public static void main(String[] args) {

    }
}
