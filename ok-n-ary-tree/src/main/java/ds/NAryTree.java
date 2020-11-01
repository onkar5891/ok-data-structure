package ds;

import java.util.ArrayDeque;
import java.util.Queue;

import static java.util.Objects.isNull;

public class NAryTree {
    public String levelOrder(Node root) {
        if (isNull(root)) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            sb.append(node.data).append(", ");
            queue.addAll(node.children);
        }

        return sb.substring(0, sb.length() - 2);
    }

    public int height(Node root) {
        if (root == null) {
            return -1;
        }
        int maxSubTreeHeight = -1;
        for (Node child : root.children) {
            maxSubTreeHeight = Math.max(maxSubTreeHeight, height(child));
        }

        return 1 + maxSubTreeHeight;
    }
}
