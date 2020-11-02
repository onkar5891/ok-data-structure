package ds.binarytree.traversal;

import ds.binarytree.VNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.util.Objects.nonNull;

public class InOrderWithoutRecursion {
    public String traverse(VNode root) {
        Deque<VNode> stack = new ArrayDeque<>();
        VNode current = root;

        // Push all left children of root, including the root itself
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            VNode top = stack.pop();
            sb.append(top.value).append(", ");
            top.visited = true;

            // Put the right child to stack (if exists) so that it gets printed next
            if (nonNull(top.right)) {
                stack.push(top.right);

                // For this right child, push all the left children to stack, so that its left subtree gets printed next
                VNode temp = top.right.left;
                while (temp != null) {
                    if (!temp.visited) {
                        stack.push(temp);
                    }
                    temp = temp.left;
                }
            }
        }

        return sb.substring(0, sb.length() - 2);
    }
}
