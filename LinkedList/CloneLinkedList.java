package LinkedList;

import java.util.HashMap;

class LinkedNode {
    int data;
    LinkedNode random, next;

    LinkedNode(int x) {
        data = x;
    }
}

public class CloneLinkedList {

    public static LinkedNode clone(LinkedNode head) {
        HashMap<LinkedNode, LinkedNode> hm = new HashMap<LinkedNode, LinkedNode>();
        for (LinkedNode curr = head; curr != null; curr = curr.next)
            hm.put(curr, new LinkedNode(curr.data));

        for (LinkedNode curr = head; curr != null; curr = curr.next) {
            LinkedNode cloneCurr = hm.get(curr);
            cloneCurr.next = hm.get(curr.next);
            cloneCurr.random = hm.get(curr.random);
        }
        LinkedNode head2 = hm.get(head);

        return head2;
    }

    public static LinkedNode cloneEff(LinkedNode head) {
        LinkedNode curr = head;
        // 1. Insert clones.
        while (curr != null) {
            LinkedNode temp = new LinkedNode(curr.data);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next;
        }
        // 2. connect clone nodes with random nodes
        for (curr = head; curr != null; curr = curr.next.next) {
            curr.next.random = (curr.random == null) ? null : curr.random.next;
        }
        // 3. Seperate original and clone nodes
        LinkedNode original = head;
        LinkedNode copy = head.next;
        LinkedNode temp = copy;
        while (original != null && copy != null) {
            original.next = original.next != null
                    ? original.next.next
                    : original.next;// changing links
            copy.next = copy.next != null
                    ? copy.next.next
                    : copy.next;// changing links
            original = original.next; // changing ref point
            copy = copy.next;// chaging ref point
        }
        return temp;
    }

    public static void print(LinkedNode start) {
        LinkedNode ptr = start;
        while (ptr != null) {
            System.out.println("Data = " + ptr.data + ", Random  = " + ptr.random.data);
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(10);
        head.next = new LinkedNode(5);
        head.next.next = new LinkedNode(20);
        head.next.next.next = new LinkedNode(15);
        head.next.next.next.next = new LinkedNode(20);

        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next.next.next;
        print(head);

    }
}
