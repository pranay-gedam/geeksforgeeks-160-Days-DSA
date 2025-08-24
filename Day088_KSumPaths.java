package gfg160Days_DSA;

import java.util.HashMap;
import java.util.Map;

public class Day088_KSumPaths {

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

    public int sumK(Node root, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // Initialize with sum 0 occurring once
        prefixSumCount.put(0, 1);
        return dfs(root, k, 0, prefixSumCount);
    }

    private int dfs(Node node, int k, int currentSum, Map<Integer, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }

        int totalPaths = 0;
        currentSum += node.data;

        // Check if there's a prefix sum we can subtract to get k
        totalPaths += prefixSumCount.getOrDefault(currentSum - k, 0);

        // Increment current sum count
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Explore children
        totalPaths += dfs(node.left, k, currentSum, prefixSumCount);
        totalPaths += dfs(node.right, k, currentSum, prefixSumCount);

        // Backtrack: remove one count of current sum before returning
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return totalPaths;
    }

    public static void main(String[] args) {
        Day088_KSumPaths solution = new Day088_KSumPaths();

        // Build your specific test case tree here
        // Example: Below is just a placeholder; replace with your test case:
        // Node root = solution.new Node(-1);
        // root.left = solution.new Node(-2);
        // ...

        // For your specific test input, you will need to construct the tree appropriately

        // For demonstration, let's do a simple test:
        Node root = solution.new Node(1);
        root.left = solution.new Node(2);
        root.right = solution.new Node(3);
        int k = 3;
        System.out.println("Paths sum to " + k + ": " + solution.sumK(root, k));
    }
}