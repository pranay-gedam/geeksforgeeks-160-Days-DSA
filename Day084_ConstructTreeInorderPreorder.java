package gfg160Days_DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day084_ConstructTreeInorderPreorder {

    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static Node buildTree(int inorder[], int preorder[]) {
        // Map to store the index of each value in inorder for quick lookup
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Initialize a variable to keep track of the current index in preorder array
        int[] preorderIndex = {0};
        return buildTreeHelper(preorder, inorderMap, 0, inorder.length - 1, preorderIndex);
    }

    private static Node buildTreeHelper(int[] preorder, Map<Integer, Integer> inorderMap,
                                        int inorderStart, int inorderEnd, int[] preorderIndex) {
        // Base case
        if (inorderStart > inorderEnd) {
            return null;
        }

        // Get the current root value from preorder traversal
        int rootVal = preorder[preorderIndex[0]];
        Node root = new Node(rootVal); // getting error as make buildTreeHelper non static...

        // Move to the next index in preorder array
        preorderIndex[0]++;

        // Find the root in inorder traversal
        int inorderRootIndex = inorderMap.get(rootVal);

        // Recursively build left and right subtrees
        root.left = buildTreeHelper(preorder, inorderMap, inorderStart, inorderRootIndex - 1, preorderIndex);
        root.right = buildTreeHelper(preorder, inorderMap, inorderRootIndex + 1, inorderEnd, preorderIndex);

        return root;
    }

    // Method to perform postorder traversal and return the sequence as a list
    public static List<Integer> getPostOrder(Node root) {
        List<Integer> postOrderList = new ArrayList<>();
        postOrderTraversal(root, postOrderList);
        return postOrderList;
    }

    private static void postOrderTraversal(Node root, List<Integer> list) {
        if (root == null) return;
        postOrderTraversal(root.left, list);
        postOrderTraversal(root.right, list);
        list.add(root.data);
    }

    public static void main(String[] args) {
        // Example 1
        int[] inorder1 = {1, 6, 8, 7};
        int[] preorder1 = {1, 6, 7, 8};

        Node root1 = buildTree(inorder1, preorder1);
        List<Integer> postOrder1 = getPostOrder(root1);
        System.out.println(postOrder1); // Expected: [8, 7, 6, 1]

        // Example 2
        int[] inorder2 = {3, 1, 4, 0, 2, 5};
        int[] preorder2 = {0, 1, 3, 4, 2, 5};

        Node root2 = buildTree(inorder2, preorder2);
        List<Integer> postOrder2 = getPostOrder(root2);
        System.out.println(postOrder2); // Expected: [3, 4, 1, 5, 2, 0]

        // Example 3
        int[] inorder3 = {2, 5, 4, 1, 3};
        int[] preorder3 = {1, 4, 5, 2, 3};

        Node root3 = buildTree(inorder3, preorder3);
        List<Integer> postOrder3 = getPostOrder(root3);
        System.out.println(postOrder3); // Expected: [2, 5, 4, 3, 1]
    }
}
