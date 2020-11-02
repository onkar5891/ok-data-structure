package ds.binarytree.misc;

import ds.binarytree.Node;

public class PathSum {
    private final Node root;

    public PathSum(Node root) {
        this.root = root;
    }

    public boolean pathExistsWithSum(int sum) {
        return pathExistsWithSumInternal(root, 0, sum);
    }

    // Use the preorder traversal to calculate sum as and when nodes are visited
    private boolean pathExistsWithSumInternal(Node node, int curSum, int sum) {
        // Base conditions to return false
        if (node == null || curSum > sum) {
            return false;
        }

        // Add node's value to the sum
        curSum += node.value;
        if (curSum == sum && node.isLeaf()) {
            // If the node is a leaf node, path ends at this point
            // If sum exactly matches this path, return true
            return true;
        }

        // Recursively find sum for left and right sub-trees
        return pathExistsWithSumInternal(node.left, curSum, sum) || pathExistsWithSumInternal(node.right, curSum, sum);
    }
}
