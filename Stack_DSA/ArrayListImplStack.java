package Stack_DSA;

import java.util.ArrayList;

class ArrLStack {
    ArrayList<Integer> list = new ArrayList<>();

    void push(int x) {
        list.add(x);
    }

    int pop() {
        int res = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return res;
    }

    int peek() {
        return list.get(list.size() - 1);
    }

    boolean isEmpty() {
        return list.isEmpty();
    }

    int size() {
        return list.size();
    }
}

public class ArrayListImplStack {
    public static void main(String[] args) {
        ArrLStack s = new ArrLStack();
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
