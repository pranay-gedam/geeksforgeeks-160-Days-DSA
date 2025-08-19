package gfg160Days_DSA;

public class Day082_DiameterBinaryTree {

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    int maxDiameter = 0;  // to keep track of the maximum diameter found

    int diameter(Node root) {
        height(root);
        return maxDiameter;
    }

    int height(Node node) {
        if (node == null) {
            return -1;  // height of null node is -1 (since edges are counted)
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update maximum diameter if the path through this node is longer
        int localDiameter = leftHeight + rightHeight + 2;  // edges between the farthest leaves
        if (localDiameter > maxDiameter) {
            maxDiameter = localDiameter;
        }

        // Return height of current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Day082_DiameterBinaryTree solution = new Day082_DiameterBinaryTree();

        // Example 1: Tree with nodes [1, 2, 3]
        Node root1 = solution.new Node(1);
        root1.left = solution.new Node(2);
        root1.right = solution.new Node(3);
        System.out.println("Diameter of Tree 1: " + solution.diameter(root1));  // Expected output: 2

        // Example 2: Tree with nodes [5, 8, 6, 3, 7, 9]
        Node root2 = solution.new Node(5);
        root2.left = solution.new Node(8);
        root2.right = solution.new Node(6);
        root2.left.left = solution.new Node(3);
        root2.left.right = solution.new Node(7);
        root2.right.right = solution.new Node(9);
        System.out.println("Diameter of Tree 2: " + solution.diameter(root2));  // Expected output: 4

        // Add additional tests as needed
    }
}
