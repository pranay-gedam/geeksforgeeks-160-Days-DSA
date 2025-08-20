package gfg160Days_DSA;

import java.util.ArrayList;

public class Day085_InOrderTraversal {

    class Node {
        int data;
        Node left, right;
        Node(int item)    {
            data = item;
            left = right = null;
        }
    }

    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, result);
        result.add(node.data);
        inOrderTraversal(node.right, result);
    }

    public static void main(String[] args) {
        Day085_InOrderTraversal traversal = new Day085_InOrderTraversal();

        // Building a sample tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        Node root = traversal.new Node(1);
        root.left = traversal.new Node(2);
        root.right = traversal.new Node(3);
        root.left.left = traversal.new Node(4);
        root.left.right = traversal.new Node(5);

        ArrayList<Integer> result = traversal.inOrder(root);
        System.out.println(result); // Should print [4, 2, 5, 1, 3]
    }
}
