package Stack_DSA;

class kStacks {
    int arr[], top[], next[];
    int free_top = 0, cap;

    kStacks(int k, int n) {
        cap = n;
        arr = new int[n];
        next = new int[n];
        top = new int[k];

        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    void push(int sn, int x) {// stack number, elem
        if (isFull()) {
            System.out.println("Stack Overflow");
        }
        int i = free_top;
        free_top = next[i];
        next[i] = top[sn];
        top[sn] = i;
        arr[i] = x;
    }

    int pop(int sn) {
        if (isEmpty(sn)) {
            System.out.println("STACK UNDERFLOW");
        }
        int i = top[sn];
        top[sn] = next[i];
        next[i] = free_top;
        free_top = i;
        return arr[i];

    }

    boolean isFull() {
        return (free_top == -1);
    }

    boolean isEmpty(int sn) {
        return (top[sn] == -1);
    }
}

public class ImplKStacksArray {
    public static void main(String[] args) {
        int k = 3, n = 10;
        kStacks ks = new kStacks(k, n);

        ks.push(2, 15);
        ks.push(2, 10);

        ks.push(1, 0);
        ks.push(0, 3);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));// 10
        System.out.println("Popped element from stack 1 is " + ks.pop(1));// 0
        System.out.println("Popped element from stack 0 is " + ks.pop(0));// 3

    }
}
