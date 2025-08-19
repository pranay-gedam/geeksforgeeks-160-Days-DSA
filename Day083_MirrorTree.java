package gfg160Days_DSA;

public class Day083_MirrorTree {

    class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if (node == null) return; // Base case: if the node is null, do nothing

        // Swap the left and right children
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively call mirror on left and right subtrees
        mirror(node.left);
        mirror(node.right);
    }

    public static void main(String[] args) {
        Day083_MirrorTree tree = new Day083_MirrorTree();

        // Create a simple binary tree:
        //       1
        //      / \
        //     2   3
        //        /
        //       4
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.right.left = tree.new Node(4);

        // Print the original tree (in-order traversal)
        System.out.print("Original Tree (In-order): ");
        tree.inOrder(root);
        System.out.println();

        // Call mirror
        tree.mirror(root);

        // Print the mirrored tree
        System.out.print("Mirrored Tree (In-order): ");
        tree.inOrder(root);
        System.out.println();
    }

    // Utility method for in-order traversal
    void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
}
