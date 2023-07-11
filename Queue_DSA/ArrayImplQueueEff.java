package Queue_DSA;

// Efficinet impl with circular array
class CArrQueue {
    private int capacity, size, front, rear;
    private int[] arr;

    public CArrQueue(int c) {
        this.capacity = c;
        size = 0;
        front = 0;
        rear = capacity - 1;
        arr = new int[capacity];
    }

    public void enqueue(int x) {
        if (!isFull()) {
            rear = (rear + 1) % capacity;
            arr[rear] = x;
            size = size + 1;
        } else {
            System.out.println("Queue is full");
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int res = arr[front];
        front = (front + 1) % capacity;
        size = size - 1;
        return res;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}

public class ArrayImplQueueEff {
    public static void main(String[] args) {
        CArrQueue q = new CArrQueue(4);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println("Front:" + q.getFront());// 2
        System.out.println("Rear:" + q.getRear());// 4
        System.out.println(q.dequeue());// removes 2
        System.out.println("Front:" + q.getFront());// 3
        q.enqueue(5);// 3,4,5
        q.enqueue(6);// 3,4,5,6
        System.out.println("Front:" + q.getFront());// 3
        System.out.println("Rear:" + q.getRear());// 6
        q.enqueue(7);// queue is full
        System.out.println(q.dequeue()); // removes -3|| 4,5,6
    }
}
