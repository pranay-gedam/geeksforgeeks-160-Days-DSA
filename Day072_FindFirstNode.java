package gfg160Days_DSA;

class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}

public class Day072_FindFirstNode {

    public static Node findFirstNode(Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head;

        // Detect loop using Floyd's cycle detection algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Loop detected, now find the start node of the loop
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // The start node of the loop
            }
        }
        return null; // No loop found
    }

    public static void main(String[] args) {
        // Example: Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int pos = 3; // Loop starts at node with value 3
        createLoop(head, pos);

        Node loopStart = Day072_FindFirstNode.findFirstNode(head);
        if (loopStart != null) {
            System.out.println("Loop starts at node with data: " + loopStart.data);
        } else {
            System.out.println("-1");
        }
    }

    // Method to create a loop at position 'pos' (1-based)
    private static void createLoop(Node head, int pos) {
        if (pos == 0) return; // No loop
        Node current = head;
        Node loopNode = null;
        int count = 1;
        while (current.next != null) {
            if (count == pos) {
                loopNode = current;
            }
            current = current.next;
            count++;
        }
        if (loopNode != null) {
            current.next = loopNode; // Creating loop
        }
    }
}