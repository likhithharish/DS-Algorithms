package Deque_DSA;

import java.util.*;

//deque implementation using array
class ArrDeque {
    // using circular array
    public int capacity, size, front, rear;
    private int[] arr;

    public ArrDeque(int k) {
        arr = new int[k];
        capacity = k;
        size = 0;
        front = 0;
        rear = k - 1;
    }

    public void insertFront(int x) {
        if (!isFull()) {
            front = (front - 1 + capacity) % capacity;
            arr[front] = x;
            size++;
        } else {
            System.out.println("Deque is Full");
        }
    }

    public void insertRear(int x) {
        if (!isFull()) {
            rear = (rear + 1) % capacity;
            arr[rear] = x;
            size++;
        }
    }

    public int deleteFront() {
        if (isEmpty()) {
            return -1;
        }
        int res = arr[front];
        front = (front + 1) % capacity;
        size--;
        return res;
    }

    public int deleteRear() {
        if (isEmpty()) {
            return -1;
        }
        int res = arr[rear];
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return res;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }
}

public class ArrayImplDeque {
    public static void main(String[] args) {
        ArrDeque dq = new ArrDeque(6);
        dq.insertFront(1);
        dq.insertFront(2);
        dq.insertFront(3);
        dq.insertRear(4);
        dq.insertRear(5);
        dq.insertRear(6);
        System.out.println("Front:" + dq.getFront());// 3
        System.out.println("Rear :" + dq.getRear());// 6
        dq.deleteFront();// deletes 3
        dq.deleteRear();// deletes 6
        System.out.println("Front:" + dq.getFront());// 2
        System.out.println("Rear :" + dq.getRear());// 5
        dq.deleteFront();// deletes 2
        dq.deleteRear();// deletes 5
        System.out.println("Front:" + dq.getFront());// 1
        System.out.println("Rear :" + dq.getRear());// 4
        System.out.println("Size :" + dq.size());// size 2
        dq.insertFront(7);
        dq.insertRear(10);
        dq.print();
        System.out.println("Front:" + dq.getFront());// 7
        System.out.println("Rear :" + dq.getRear());// 10
        System.out.println("Size :" + dq.size());// 4
        dq.deleteRear();// deletes 10
        System.out.println("Rear :" + dq.getRear());// 4
        System.out.println("FRONT:" + dq.getFront());
    }
}
