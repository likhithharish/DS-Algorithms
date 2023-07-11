package Queue_DSA;

import java.util.*;

public class ReverseQueue {

    public static Queue reverseIter(Queue<Integer> que) {
        Stack<Integer> st = new Stack<>();
        while (!que.isEmpty()) {
            st.push(que.remove());
        }

        while (!st.isEmpty()) {
            que.add(st.pop());
        }
        return que;
    }

    public static void reverseQueRec(Queue<Integer> que) {
        if (que.isEmpty()) {
            return;
        }
        int x = que.peek();
        que.remove();
        reverseQueRec(que);
        que.add(x);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(5);
        q.add(15);
        q.add(20);
        System.out.println("Before Reverse:" + Arrays.toString(q.toArray()));
        // q = reverseIter(q);
        reverseQueRec(q);
        System.out.println("After Reverse:" + Arrays.toString(q.toArray()));
    }
}
