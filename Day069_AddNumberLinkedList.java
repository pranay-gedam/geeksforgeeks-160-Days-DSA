package gfg160Days_DSA;

public class Day069_AddNumberLinkedList {

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

    // Function to reverse a linked list
    static Node reverse(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to remove leading zeros
    static Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head == null ? new Node(0) : head;
    }

    static Node addTwoLists(Node num1, Node num2) {
        // Remove leading zeros
        num1 = removeLeadingZeros(num1);
        num2 = removeLeadingZeros(num2);

        // Reverse both lists
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;

        // Add digits
        while (num1 != null || num2 != null || carry != 0) {
            int sum = carry;
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }

            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
        }

        // Reverse result
        return reverse(dummy.next);
    }

    // Helper function to print linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Helper function to create linked list from array
    static Node createList(int[] arr) {
        Node dummy = new Node(0);
        Node current = dummy;
        for (int num : arr) {
            current.next = new Node(num);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7
        Node num1 = createList(new int[]{0, 0, 6, 3});
        Node num2 = createList(new int[]{0, 7});

        Node result = addTwoLists(num1, num2);
        System.out.print("Output: ");
        printList(result); // Expected Output: 7 -> 0
    }
}
