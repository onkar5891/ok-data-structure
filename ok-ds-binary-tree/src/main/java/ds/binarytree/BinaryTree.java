package ds.binarytree;

import ds.binarytree.traversal.InOrderWithoutRecursion;
import ds.binarytree.traversal.StandardPreInPost;

import java.util.LinkedList;
import java.util.Queue;

import static java.util.Objects.nonNull;

public class BinaryTree {
    private final StandardPreInPost traversal = new StandardPreInPost();
    private final InOrderWithoutRecursion inOrderWithoutRecursion = new InOrderWithoutRecursion();
    private Node root;

    public void insert(int v) {
        if (root == null) {
            root = new Node(v);
            return;
        }

        // Use BFS technique to insert in level order
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();

            if (temp.left == null) {
                temp.left = new Node(v);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(v);
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    public void delete(int v) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node temp = null;
        Node del = null;
        while (!queue.isEmpty()) {
            temp = queue.remove();

            if (temp.value == v) {
                // don't break the loop as we need a pointer to deepest element which would be temp
                del = temp;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        if (nonNull(del)) {
            // temp points to deepest element
            deleteDeepest(temp);
            // replace the key of node under deletion with deepest node's key
            del.value = temp.value;
        }
    }

    private void deleteDeepest(Node del) {
        if (root == null) {
            return;
        } else if (root == del) {
            root = null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();

            if (nonNull(temp.left)) {
                if (temp.left.value == del.value) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
            if (nonNull(temp.right)) {
                if (temp.right.value == del.value) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }
        }
    }

    public String preorder() {
        return traversal.preorder(root);
    }

    public String inorder() {
        return traversal.inorder(root);
    }

    public String inorderWithoutRecursion() {
        return inOrderWithoutRecursion.traverse(root);
    }
}
