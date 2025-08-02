package gfg160Days_DSA;

import java.util.*;

public class Day071_LoopDetection {

    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null; }
    }

    public static boolean detectLoop(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move by one
            fast = fast.next.next;     // move by two

            if (slow == fast) {
                return true; // Loop detected
            }
        }
        // No loop
        return false;
    }

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Read input data
            int n = sc.nextInt(); // number of nodes
            int[] nodesData = new int[n];
            for (int i = 0; i < n; i++) {
                nodesData[i] = sc.nextInt();
            }
            int pos = sc.nextInt(); // position where last node links to

            // Build the linked list
            Node head = null;
            Node tail = null;
            Node[] nodesArr = new Node[n]; // to keep track of nodes for linking
            for (int i = 0; i < n; i++) {
                nodesArr[i] = new Node(nodesData[i]);
                if (head == null) {
                    head = nodesArr[i];
                    tail = head;
                } else {
                    tail.next = nodesArr[i];
                    tail = tail.next;
                }
            }

            // Create loop if pos > 0
            if (pos > 0 && pos <= n) {
                tail.next = nodesArr[pos -1]; // pos is 1-based
            }

            // Detect loop
            boolean result = Day071_LoopDetection.detectLoop(head);
            System.out.println(result);
    }
}
