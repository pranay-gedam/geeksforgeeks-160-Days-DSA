package gfg160Days_DSA;

public class Day070_CloneLinkedList {

    static class Node {
        int data;
        Node next;
        Node random;

        Node(int x) {
            data = x;
            next = null;
            random = null;
        }
    }

    public Node cloneLinkedList(Node head) {
        if (head == null) return null;

        // Step 1: Insert cloned nodes
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.data);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the cloned list
        Node dummy = new Node(0);
        Node cloneCurr = dummy;
        curr = head;
        while (curr != null) {
            cloneCurr.next = curr.next;
            cloneCurr = cloneCurr.next;
            curr.next = cloneCurr.next; // restore original list
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example: Creating nodes
        Node head = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(9);

        // Linking next pointers
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Setting random pointers
        head.random = node3;     // 1 -> 5
        node2.random = node3;    // 3 -> 5
        node3.random = null;     // 5 -> null
        node4.random = node2;    // 9 -> 3

        Day070_CloneLinkedList solution = new Day070_CloneLinkedList();
        Node clonedHead = solution.cloneLinkedList(head);

        // Print original and cloned lists
        System.out.println("Original list:");
        printList(head);
        System.out.println("\nCloned list:");
        printList(clonedHead);
    }

    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            int randData = (current.random != null) ? current.random.data : -1;
            System.out.printf("Node %d (Random: %d)\n", current.data, randData);
            current = current.next;
        }
    }
}
