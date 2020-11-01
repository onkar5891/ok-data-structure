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

    private boolean pathExistsWithSumInternal(Node node, int curSum, int sum) {
        if (node == null || curSum > sum) {
            return false;
        }

        curSum += node.value;
        if (curSum == sum && node.isLeaf()) {
            return true;
        }

        if (pathExistsWithSumInternal(node.left, curSum, sum)) {
            return true;
        }
        return pathExistsWithSumInternal(node.right, curSum, sum);
    }
}
