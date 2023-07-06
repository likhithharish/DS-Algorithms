package LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

class PNode {
    char data;
    PNode next;

    PNode(char x) {
        data = x;
        next = null;
    }
}

public class PalindromeLinkedList {

    static boolean isPalindrome(PNode head) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (PNode curr = head; curr != null; curr = curr.next)
            stack.push(curr.data);
        for (PNode curr = head; curr != null; curr = curr.next) {
            if (stack.pop() != curr.data)
                return false;
        }
        return true;
    }

    static boolean isPalindromeEff(PNode head) {
        if (head == null)
            return true;
        PNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        PNode rev = reverseList(slow.next);
        PNode curr = head;
        while (rev != null) {
            if (rev.data != curr.data)
                return false;
            rev = rev.next;
            curr = curr.next;
        }
        return true;
    }

    static PNode reverseList(PNode head) {
        if (head == null || head.next == null)
            return head;
        PNode rest_head = reverseList(head.next);
        PNode rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }

    public static void main(String[] args) {
        PNode head = new PNode('g');
        head.next = new PNode('f');
        head.next.next = new PNode('g');
        if (isPalindrome(head))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
