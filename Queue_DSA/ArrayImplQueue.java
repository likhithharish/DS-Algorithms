package Queue_DSA;

import java.util.Arrays;

// Simple impl with front always at 0, dequeue costs O(n)
class ArrQueue {
    private int capacity;
    private int count;
    private int[] arr;

    public ArrQueue(int x) {
        this.capacity = x;
        count = 0;
        arr = new int[capacity];
    }

    void enqueue(int x) {
        if (isEmpty()) {
            arr[count] = x;
            count++;
            return;
        }
        if (!isFull()) {
            arr[count] = x;
            count++;
        } else {
            System.out.println("Queue is Full");
        }
    }

    int dequeue() {
        int res = arr[0];
        for (int i = 1; i < count; i++) {
            arr[i - 1] = arr[i];
        }
        count--;
        System.out.println("Arr:" + Arrays.toString(arr) + "Count:" + count);
        return res;
    }

    int getFront() {
        return arr[0];
    }

    int getRear() {
        return arr[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count >= capacity;
    }
}

public class ArrayImplQueue {
    public static void main(String[] args) {
        ArrQueue q = new ArrQueue(4);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println("Front:" + q.getFront());// 2
        System.out.println("Rear:" + q.getRear());// 4
        q.dequeue();// removes 2
        System.out.println(q.getFront());// 3
        q.enqueue(5);// 3,4,5
        q.enqueue(6);// 3,4,5,6
        System.out.println(q.getFront());// 3
        System.out.println(q.getRear());// 6
        q.enqueue(7);// queue is full
        q.dequeue(); // 4,5,6
    }
}
