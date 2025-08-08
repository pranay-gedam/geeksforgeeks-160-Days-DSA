package gfg160Days_DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day074_LRUCache {

    class LRUCache {
        private class Node {
            int key;
            int value;
            Node prev;
            Node next;
        }

        private int capacity;
        private HashMap<Integer, Node> map;
        private Node head, tail;

        public LRUCache(int cap) {
            this.capacity = cap;
            this.map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        private void addNode(Node node) {
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }

        private void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        private void moveToTail(Node node) {
            removeNode(node);
            addNode(node);
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                moveToTail(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                moveToTail(node);
            } else {
                if (map.size() == capacity) {
                    Node lru = head.next; // least recently used
                    removeNode(lru);
                    map.remove(lru.key);
                }
                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;
                addNode(newNode);
                map.put(key, newNode);
            }
        }
    }

    public static void main(String[] args) {
        // Instantiate LRUCache with capacity 2
        Day074_LRUCache outer = new Day074_LRUCache();
        LRUCache cache = outer.new LRUCache(2);

        // Define queries as an array of arrays: {operation, key, value}
        String[][] queries = {
                {"PUT", "1", "2"},
                {"PUT", "2", "3"},
                {"PUT", "1", "5"},
                {"PUT", "4", "5"},
                {"PUT", "6", "7"},
                {"GET", "4"},
                {"PUT", "1", "2"},
                {"GET", "3"}
        };

        List<Integer> results = new ArrayList<>();

        for (String[] q : queries) {
            String op = q[0];
            int key = Integer.parseInt(q[1]);
            if (op.equals("PUT")) {
                int value = Integer.parseInt(q[2]);
                cache.put(key, value);
            } else if (op.equals("GET")) {
                results.add(cache.get(key));
            }
        }

        System.out.println(results); // Expected output: [5, -1]
    }
}
