package gfg160Days_DSA;

public class Day067_MergeSortedLists {

    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    Node sortedMerge(Node head1, Node head2) {
        // Dummy node to simplify edge cases
        Node dummy = new Node(0);
        Node current = dummy;

        // Traverse both lists and attach the smaller node to current
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes, if any
        if (head1 != null) {
            current.next = head1;
        } else if (head2 != null) {
            current.next = head2;
        }

        return dummy.next; // Return the head of merged list
    }

    public static void main(String[] args) {
        Day067_MergeSortedLists solution = new Day067_MergeSortedLists();

        // Create first sorted list: 5 -> 10 -> 15 -> 40
        Node head1 = solution.new Node(5);
        head1.next = solution.new Node(10);
        head1.next.next = solution.new Node(15);
        head1.next.next.next = solution.new Node(40);

        // Create second sorted list: 2 -> 3 -> 20
        Node head2 = solution.new Node(2);
        head2.next = solution.new Node(3);
        head2.next.next = solution.new Node(20);

        // Merge the lists
        Node mergedHead = solution.sortedMerge(head1, head2);

        // Print the merged list
        printList(mergedHead);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }
}
