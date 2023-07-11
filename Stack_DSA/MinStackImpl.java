package Stack_DSA;

import java.util.*;

class MinStack {
    // METHOD 1: Using two stacks , one stack maintain original stack and other
    // maintains minimums.
    private Stack<Integer> st = new Stack<>();
    private Stack<Integer> auxSt = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {

        st.push(val);
        if (auxSt.isEmpty() || auxSt.peek() >= st.peek()) {
            auxSt.push(val);
        }
    }

    public void pop() {

        if (auxSt.peek().equals(st.peek())) {
            auxSt.pop();
        }
        st.pop();
    }

    public int top() {

        return st.peek();
    }

    public int getMin() {
        return auxSt.peek();
    }

}

class MinStackMod {
    // assuming all are positive values
    private Stack<Integer> s = new Stack<>();
    private int min;

    public MinStackMod() {
        min = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (min == Integer.MIN_VALUE) {
            min = x;
            s.push(x);
            return;
        }
        if (x <= min) {
            s.push(x - min);
            min = x;
            return;
        }
        s.push(x);
    }

    public void pop() {
        if (s.peek() < 0) {
            min = min - s.peek();
        }
        s.pop();

    }

    public int peek() {
        if (s.peek() < 0) {
            return min;
        }
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}

class MyStackEff {
    Stack<Integer> s;
    int min;

    MyStackEff() {
        s = new Stack<>();
    }

    void push(int x) {
        if (s.isEmpty()) {
            min = x;
            s.add(x);
        } else if (x <= min) {
            s.add(2 * x - min);
            min = x;
        } else {
            s.add(x);
        }
    }

    int pop() {

        int t = s.peek();
        s.pop();
        if (t <= min) {
            int res = min;
            min = 2 * min - t;
            return res;
        } else {
            return t;
        }
    }

    int peek() {
        int t = s.peek();
        return ((t <= min) ? min : t);
    }

    int getMin() {
        return min;
    }
}

public class MinStackImpl {
    // Implement MinStack in O(1)
    public static void main(String[] args) {
        MinStackMod s = new MinStackMod();
        s.push(5);
        s.push(10);
        s.push(20);
        System.out.println(s.getMin());// 5
        s.push(2);
        s.push(6);
        s.push(4);
        System.out.println(s.getMin());// 2
        s.pop();
        s.pop();
        System.out.println(s.getMin());// 2
        s.pop();
        System.out.println(s.getMin());// 5
        s.push(1);
        System.out.println(s.getMin());// 1
    }
}
