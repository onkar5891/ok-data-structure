package ds.binarytree.traversal;

import ds.binarytree.Node;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.util.Objects.nonNull;

public class InOrderWithoutRecursion {
    public String traverse(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;

        // Push all left children of root, including the root itself
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            sb.append(top.value).append(", ");

            // If root is visited, put the right child to stack so that it gets printed next
            if (nonNull(top.right)) {
                stack.push(top.right);
            }
        }

        return sb.substring(0, sb.length() - 2);
    }
}
