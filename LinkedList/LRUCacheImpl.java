package LinkedList;

import java.util.HashMap;

class LRUNode {
    int key;
    int value;
    LRUNode prev;
    LRUNode next;

    LRUNode(int k, int val) {
        this.key = k;
        this.value = val;
    }
}

class LRUCache {
    private HashMap<Integer, LRUNode> map;
    private int capacity, count;
    private LRUNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LRUNode(0, 0);
        tail = new LRUNode(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    public void set(int key, int value) {
        System.out.println("Going to set the (key, value) : (" + key + ", " + value + ")");
        if (map.get(key) == null) {
            LRUNode node = new LRUNode(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        } else {
            LRUNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
    }

    public void deleteNode(LRUNode node) {
        node.prev.next = node.next; // marking cuur node's prev node to curr node's next node
        node.next.prev = node.prev; // marking curr node's next node to curr node's prev node.
    }

    public void addToHead(LRUNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            LRUNode node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            System.out.println("Got the value : " + result + " for the key: " + key);
            return result;
        }
        System.out.println("Did not get any value for the key: " + key);
        return -1;
    }
}

public class LRUCacheImpl {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set(1, 10);
        cache.set(2, 20);

        System.out.println("Value for the key: 1 is " + cache.get(1));

        cache.set(3, 30);

        System.out.println("Value for the key: 2 is " + cache.get(2));

        cache.set(4, 40);

        System.out.println("Value for the key: 1 is " + cache.get(1));
        System.out.println("Value for the key: 3 is " + cache.get(3));
        System.out.println("Value for the key: 4 is " + cache.get(4));
    }
}
