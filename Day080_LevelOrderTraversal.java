package gfg160Days_DSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Day080_LevelOrderTraversal {

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // number of nodes at current level
            ArrayList<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.data);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        Day080_LevelOrderTraversal solution = new Day080_LevelOrderTraversal();

        // Construct sample tree: [1, 2, 3]
        Node root = solution.new Node(1);
        root.left = solution.new Node(2);
        root.right = solution.new Node(3);

        // Call levelOrder traversal
        ArrayList<ArrayList<Integer>> result = solution.levelOrder(root);

        // Print the result
        System.out.println(result);
    }
}
