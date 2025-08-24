package gfg160Days_DSA;

public class Day089_CheckForBST {

    // Make Node class static to instantiate without outer class reference
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Previous node value, initialized to null
    Long prev = null;

    // Function to check if the binary tree is BST
    boolean isBST(Node root) {
        // In-order traversal
        if (root == null) {
            return true;
        }
        // Check left subtree
        if (!isBST(root.left)) {
            return false;
        }
        // Check current node
        if (prev != null && root.data <= prev) {
            return false;
        }
        prev = (long) root.data;
        // Check right subtree
        return isBST(root.right);
    }

    public static void main(String[] args) {
        Day089_CheckForBST solution = new Day089_CheckForBST();

        // Example 1: Valid BST
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(3);
        System.out.println("Tree 1 is BST: " + solution.isBST(cloneTree(root1)));  // Should print true

        // Reset prev for new test
        solution.prev = null;

        // Example 2: Not a BST (node with value 6 on right of 7)
        Node root2 = new Node(2);
        root2.left = null;
        root2.right = new Node(7);
        root2.right.left = new Node(6);
        root2.right.right = new Node(9);
        System.out.println("Tree 2 is BST: " + solution.isBST(cloneTree(root2))); // Should print false

        // Reset prev
        solution.prev = null;

        // Example 3: Not a BST (node with value 9 in right subtree)
        Node root3 = new Node(10);
        root3.left = new Node(5);
        root3.right = new Node(20);
        root3.right.left = new Node(9);
        root3.right.right = new Node(25);
        System.out.println("Tree 3 is BST: " + solution.isBST(cloneTree(root3))); // Should print false
    }

    // Helper method to clone tree
    private static Node cloneTree(Node root) {
        if (root == null) return null;
        Node newNode = new Node(root.data);
        newNode.left = cloneTree(root.left);
        newNode.right = cloneTree(root.right);
        return newNode;
    }
}