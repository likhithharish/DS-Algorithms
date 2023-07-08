package Stack_DSA;

class MyStack {
    int arr[];
    int cap;
    int top;

    MyStack(int c) {
        top = -1;
        cap = c;
        arr = new int[cap];
    }

    void push(int x) {
        if (top == cap - 1) { // overflow
            // stack is full
            // handle it by throwing exception.
        }
        top++;
        arr[top] = x;
    }

    int pop() {
        if (top == -1) {// underflow
            // empty stack
            // throw nothing to remove
        }
        int res = arr[top];
        top--;
        return res;
    }

    int peek() {
        if (top == -1) { // underflow
            // empty stack
            // throw nothing to remove
        }
        return arr[top];
    }

    int size() {
        return top + 1;
    }

    boolean isEmpty() {
        return top == -1;
    }
}

public class ArrayImplOfStack {
    public static void main(String[] args) {
        MyStack s = new MyStack(3);
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
    }
}
