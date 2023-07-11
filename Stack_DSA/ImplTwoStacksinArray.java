package Stack_DSA;

// Naive impl - divide into two  equal halves
class TwoStacks {
    int arr[];
    int cap;
    int top1, top2;
    int mid;

    TwoStacks(int n) {
        arr = new int[2 * n];
        cap = 2 * n;
        mid = n;
        top1 = -1;
        top2 = n;
    }

    void push1(int x) {
        if (top1 < mid - 1) {
            top1++;
            arr[top1] = x;
        } else {
            System.out.println("First stack is full, can't add " + x);
        }
    }

    void push2(int x) {
        if (top2 < cap - 1) {
            if (arr[mid] == 0) {
                arr[top2] = x;
                return;
            }
            top2++;
            arr[top2] = x;

        } else {
            System.out.println("Second stack is full, can't add " + x);
        }
    }

    Integer pop1() {
        if (top1 == -1) {
            return null;
        }
        int res = arr[top1];
        top1--;
        return Integer.valueOf(res);
    }

    Integer pop2() {
        if (top2 == mid && arr[top2] == 0) {
            return null;
        }
        int res = arr[top2];
        top2--;
        return Integer.valueOf(res);
    }

    Integer peek1() {
        if (top1 == -1) {
            return null;
        }
        return Integer.valueOf(arr[top1]);
    }

    Integer peek2() {
        if (top2 == -1) {
            return null;
        }
        return Integer.valueOf(arr[top2]);
    }

    int size1() {
        return top1 + 1;
    }

    int size2() {
        return top2 - mid + 1;
    }
}

public class ImplTwoStacksinArray {
    public static void main(String[] args) {
        TwoStacks s = new TwoStacks(4);
        s.push1(1);
        s.push2(9);
        s.push1(2);
        s.push2(8);
        s.push1(3);
        s.push2(7);
        s.push1(4);
        s.push2(6);
        System.out.println("Peek of S1: " + s.peek1());
        System.out.println("Peek of S2: " + s.peek2());
        s.push1(5);
        s.push2(10);
        System.out.println("Popped from S1: " + s.pop1() + "| size:" + s.size1());
        System.out.println("Peek of S1: " + s.peek1());
        System.out.println("Popped from S2: " + s.pop2() + "| size:" + s.size2());
        System.out.println("Peek of S2: " + s.peek2());
        s.push2(21);
        System.out.println("Peek of S2: " + s.peek2());
    }

}
