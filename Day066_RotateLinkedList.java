package gfg160Days_DSA;

import org.w3c.dom.Node;

public class Day066_RotateLinkedList {


    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find list length and last node
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Make it circular
        current.next = head;

        // For left rotation, new head is at position k
        k = k % length; // in case k > length
        int stepsToNewHead = k;

        // Find the new tail (the node just before newHead)
        Node newTail = current;
        for (int i = 0; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // The node after newTail is newHead
        Node newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }

    public void main(String[] args) {
        // Create linked list: 10 -> 20 -> 30 -> 40 -> 50
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        Day066_RotateLinkedList solution = new Day066_RotateLinkedList();

        // Rotate left by 4
        Node rotatedHead = solution.rotate(head, 4);
        printList(rotatedHead); // Expected output: 50 -> 10 -> 20 -> 30 -> 40 -> null

        // Reset list for next test
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        // Rotate left by 6
        rotatedHead = solution.rotate(head, 6);
        printList(rotatedHead); // Expected output: 30 -> 40 -> 10 -> 20 -> null
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
