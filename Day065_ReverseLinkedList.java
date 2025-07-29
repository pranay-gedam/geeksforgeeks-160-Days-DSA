package gfg160Days_DSA;

import org.w3c.dom.Node;

public class Day065_ReverseLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next; // store next node
            current.next = prev; // reverse the link
            prev = current; // move prev forward
            current = nextTemp; // move current forward
        }

        return prev; // prev will be the new head
    }

    public static void main(String[] args) {
        Day065_ReverseLinkedList obj = new Day065_ReverseLinkedList();

        // Build the linked list: 1 -> 2 -> 3 -> 4
        ListNode head = obj.new ListNode(1);
        head.next = obj.new ListNode(2);
        head.next.next = obj.new ListNode(3);
        head.next.next.next = obj.new ListNode(4);

        // Reverse the linked list
        ListNode reversedHead = reverseList(head);

        // Print the reversed list
        printList(reversedHead);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println(" -> NULL");
    }
}
