package gfg160Days_DSA;

public class Day068_reverseKNodes {

    class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    public Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node groupPrev = dummy;

        while (true) {
            Node kth = getKthNode(groupPrev, k);
            // Instead of stopping if kth is null, process if remaining nodes are less than k
            if (kth == null) {
                // Check how many nodes remain
                Node tail = groupPrev.next;
                int count = 0;
                while (tail != null && count < k) {
                    tail = tail.next;
                    count++;
                }
                if (count == 0) break; // no nodes left
                // Reverse remaining nodes
                Node prev = null;
                Node curr = groupPrev.next;
                while (curr != null) {
                    Node temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                }
                groupPrev.next = prev;
                break;
            }

            Node groupNext = kth.next;

            // Reverse the current group
            Node prev = groupNext;
            Node curr = groupPrev.next;

            while (curr != groupNext) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect previous part with reversed group
            Node temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;
    }

    // Helper method to get the k-th node from 'start' node
    private static Node getKthNode(Node start, int k) {
        Node curr = start;
        for (int i = 0; i < k; i++) {
            if (curr.next == null) return null;
            curr = curr.next;
        }
        return curr;
    }

    public static void main(String[] args) {
        Day068_reverseKNodes solution = new Day068_reverseKNodes();

        // Create a linked list: 1 -> 2 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8
        Node head = solution.new Node(1);
        head.next = solution.new Node(2);
        head.next.next = solution.new Node(2);
        head.next.next.next = solution.new Node(4);
        head.next.next.next.next = solution.new Node(5);
        head.next.next.next.next.next = solution.new Node(6);
        head.next.next.next.next.next.next = solution.new Node(7);
        head.next.next.next.next.next.next.next = solution.new Node(8);

        int k = 4;

        System.out.println("Original linked list:");
        printList(head);

        // Call the reverseKGroup method
        Node newHead = solution.reverseKGroup(head, k);

        System.out.println("\nReversed in groups of " + k + ":");
        printList(newHead);
    }

    // Utility method to print the list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
