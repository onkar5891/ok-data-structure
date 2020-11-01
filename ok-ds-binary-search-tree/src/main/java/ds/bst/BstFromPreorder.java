package ds.bst;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.util.Objects.isNull;

public class BstFromPreorder {
    private final StandardPreInPost traversal = new StandardPreInPost();

    public Node constructFromPreorder(int[] pre) {
        if (isNull(pre) || pre.length == 0) {
            return null;
        }

        Node root = new Node(pre[0]);
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        int i = 1;
        // Time complexity is O(n) even if it seems there's nested loop
        // The reason is each element is pushed/popped only once, so at most 2n PP operations are performed
        while (i < pre.length && !stack.isEmpty()) {
            Node temp = null;

            // Keep popping while next value is greater than stack top
            while (!stack.isEmpty() && pre[i] > stack.peek().value) {
                temp = stack.pop();
            }

            // At this point, temp's value is less than pre[i], so make it as right child
            if (temp != null) {
                temp.right = new Node(pre[i]);
                stack.push(temp.right);
            }
            // Otherwise, make it as left child of stack's top node
            else {
                temp = stack.peek();
                temp.left = new Node(pre[i]);
                stack.push(temp.left);
            }
            i++;
        }

        return root;
    }

    public String inorder(Node root) {
        return traversal.inorder(root);
    }
}
