package gfg160Days_DSA;

public class Day081_HeightBinaryTree {

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


    int height(Node node) {
        if (node == null)
            return -1; // Since height is defined as number of edges, return -1 for null nodes
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Day081_HeightBinaryTree tree = new Day081_HeightBinaryTree(); // Create instance to access inner class

        // Build the binary tree
        Node root = tree.new Node(12);
        root.left = tree.new Node(8);
        root.right = tree.new Node(18);
        root.left.left = tree.new Node(5);
        root.left.right = tree.new Node(11);

        // Compute height
        int height = tree.height(root);
        System.out.println("Height of the tree: " + height);
    }
}
