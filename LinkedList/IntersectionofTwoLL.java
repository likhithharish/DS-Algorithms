package LinkedList;

import java.util.HashSet;

public class IntersectionofTwoLL {
    public static int getIntersection(Node head1, Node head2) {
        HashSet<Integer> set = new HashSet<>();
        Node curr = head1;
        while (curr != null) {
            set.add(curr.data);
            curr = curr.next;
        }

        curr = head2;
        while (curr != null) {
            if (set.contains(curr.data)) {
                return curr.data;
            }
            curr = curr.next;
        }
        return -1;
    }

    public static int getInterEff(Node head1, Node head2) {
        Node curr = head1;
        int c1 = 1;
        while (curr.next != null) {
            c1++;
            curr = curr.next;
        }
        curr = head2;
        int c2 = 1;
        while (curr.next != null) {
            c2++;
            curr = curr.next;
        }
        int k = Math.abs(c2 - c1);
        boolean list1 = false;
        if (c1 > c2) {
            list1 = true;
            curr = head1;
            int c = 1;
            while (curr.next != null) {
                c++;
                curr = curr.next;
                if (c == k + 1) {
                    break;
                }
            }
        } else {
            curr = head2;
            int c = 1;
            while (curr.next != null) {
                c++;
                if (c == k + 1) {
                    break;
                }
                curr = curr.next;
            }
        }
        Node curr2 = (list1) ? head2 : head1;
        System.out.println(curr.data + " " + curr2.data);

        while (curr.next != null && curr2.next != null) {
            curr = curr.next;
            curr2 = curr2.next;
            if (curr == curr2) {
                break;
            }
        }
        return curr.data;
    }

    public static void main(String[] args) {
        // 1st 3->6->9->15->30
        // 2nd 10->15->30
        // Intersection = 15
        Node newNode;

        Node head1 = new Node(10);

        Node head2 = new Node(3);

        newNode = new Node(6);
        head2.next = newNode;

        newNode = new Node(9);
        head2.next.next = newNode;

        newNode = new Node(15);
        head1.next = newNode;
        head2.next.next.next = newNode;

        newNode = new Node(30);
        head1.next.next = newNode;

        head1.next.next.next = null;

        System.out.println(getIntersection(head1, head2));
        System.out.println(getInterEff(head1, head2));
    }
}
