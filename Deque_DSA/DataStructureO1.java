package Deque_DSA;

import java.util.Deque;
import java.util.LinkedList;

// Data Structure with min/ max Operations in O(1)
// Assumption : elem to be inserted is either less than min or greater than max

class DataStruct {
    Deque<Integer> dq;

    public DataStruct() {
        dq = new LinkedList<>();
    }

    void insertMin(int x) {
        dq.offerLast(x);
    }

    void insertMax(int x) {
        dq.offerFirst(x);
    }

    int getMin() {
        return dq.peekLast();
    }

    int getMax() {
        return dq.peekFirst();
    }

    int extractMin() {
        int res = dq.removeLast();
        return res;
    }

    int extractMax() {
        int res = dq.removeFirst();
        return res;
    }
}

public class DataStructureO1 {
    public static void main(String[] args) {

    }
}
