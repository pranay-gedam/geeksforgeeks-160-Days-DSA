package gfg160Days_DSA;

import java.util.ArrayList;

public class Day086_TreeBoundaryTraversal {

    class Node
    {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> boundary = new ArrayList<>();
        if (root == null) return boundary;

        // Add root
        boundary.add(root.data);

        // Helper methods
        // 1. Add left boundary (excluding leaves)
        addLeftBoundary(root.left, boundary);

        // 2. Add all leaf nodes
        addLeaves(root.left, boundary);
        addLeaves(root.right, boundary);

        // 3. Add right boundary (excluding leaves) in reverse order
        ArrayList<Integer> rightBoundary = new ArrayList<>();
        addRightBoundary(root.right, rightBoundary);
        // Reverse and add to boundary
        for (int i = rightBoundary.size() - 1; i >= 0; i--) {
            boundary.add(rightBoundary.get(i));
        }

        return boundary;
    }

    private void addLeftBoundary(Node node, ArrayList<Integer> boundary) {
        Node curr = node;
        while (curr != null) {
            if (!isLeaf(curr)) {
                boundary.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addRightBoundary(Node node, ArrayList<Integer> boundary) {
        Node curr = node;
        while (curr != null) {
            if (!isLeaf(curr)) {
                boundary.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
    }

    private void addLeaves(Node node, ArrayList<Integer> boundary) {
        if (node == null) return;
        if (isLeaf(node)) {
            boundary.add(node.data);
        } else {
            addLeaves(node.left, boundary);
            addLeaves(node.right, boundary);
        }
    }

    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    public static void main(String[] args) {
        Day086_TreeBoundaryTraversal treeTraversal = new Day086_TreeBoundaryTraversal();

        // Constructing a sample binary tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        //       / \
        //      7   8

        Node root = treeTraversal.new Node(1);
        root.left = treeTraversal.new Node(2);
        root.right = treeTraversal.new Node(3);
        root.left.left = treeTraversal.new Node(4);
        root.left.right = treeTraversal.new Node(5);
        root.left.right.left = treeTraversal.new Node(7);
        root.left.right.right = treeTraversal.new Node(8);
        root.right.right = treeTraversal.new Node(6);

        ArrayList<Integer> boundary = treeTraversal.boundaryTraversal(root);
        System.out.println(boundary);  // Expected boundary traversal output
    }
}
