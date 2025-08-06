package gfg160Days_DSA;

public class Day073_DetectAndRemoveCycle {

    public static class Node {
        int data;
        Node next;
    }

    public static class DetectAndRemoveCycle {
        public static boolean removeLoop(Node head) {
            if (head == null || head.next == null) {
                return false;
            }

            Node slow = head;
            Node fast = head;
            boolean cycleDetected = false;

            // Detect cycle
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    cycleDetected = true;
                    break;
                }
            }

            if (!cycleDetected) {
                return false; // no cycle
            }

            // Find start of loop
            slow = head;
            Node prev = null; // node before the start of the loop
            while (slow != fast) {
                prev = fast; // node before fast
                slow = slow.next;
                fast = fast.next;
            }

            // Remove cycle
            if (prev != null) {
                prev.next = null;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        // Construct linked list with a cycle for testing
        Node head = new Node();
        head.data = 1;

        Node second = new Node();
        second.data = 2;

        head.next = second;

        Node third = new Node();
        third.data = 3;

        second.next = third;
        third.next = second; // cycle here

        boolean result = DetectAndRemoveCycle.removeLoop(head);
        System.out.println(result);  // true
    }
}