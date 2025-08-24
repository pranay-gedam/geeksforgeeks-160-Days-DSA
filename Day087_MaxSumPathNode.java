package gfg160Days_DSA;

public class Day087_MaxSumPathNode {

    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    // To keep track of the maximum path sum found so far
    int maxSum = Integer.MIN_VALUE;

    int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSum;
    }

    // Helper function to compute the maximum path sum node and update global max
    int maxPathSumHelper(Node node) {
        if (node == null) {
            return 0;
        }

        // Compute max sum on the left and right subtrees, ignore negatives
        int leftMax = Math.max(0, maxPathSumHelper(node.left));
        int rightMax = Math.max(0, maxPathSumHelper(node.right));

        // Max sum at the current node when path passes through it
        int currentMax = node.data + leftMax + rightMax;

        // Update global maximum if needed
        maxSum = Math.max(maxSum, currentMax);

        // Return max sum for paths extending to parent
        return node.data + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        Day087_MaxSumPathNode solution = new Day087_MaxSumPathNode();

        // Manually creating the tree for the first example:
        Node root = solution.new Node(10);
        root.left = solution.new Node(2);
        root.right = solution.new Node(10);

        root.left.left = solution.new Node(20);
        root.left.right = solution.new Node(1);

        root.right.right = solution.new Node(-25);
        root.right.right.left = solution.new Node(3);
        root.right.right.right = solution.new Node(4);

        int maxSum = solution.findMaxSum(root);
        System.out.println("Maximum Path Sum: " + maxSum);
    }
}
