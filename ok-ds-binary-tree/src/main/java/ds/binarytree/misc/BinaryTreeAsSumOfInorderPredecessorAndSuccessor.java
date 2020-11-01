package ds.binarytree.misc;

import ds.binarytree.Node;
import ds.binarytree.traversal.StandardPreInPost;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeAsSumOfInorderPredecessorAndSuccessor {
    private final StandardPreInPost traversal = new StandardPreInPost();
    private final Node root;

    public BinaryTreeAsSumOfInorderPredecessorAndSuccessor(Node root) {
        this.root = root;
    }

    public void replace() {
        List<Integer> ps = new ArrayList<>();
        ps.add(0);
        createPS(root, ps);
        ps.add(0);
        modifyPSWithSum(root, ps);
    }

    private void createPS(Node temp, List<Integer> ps) {
        if (temp == null) {
            return;
        }

        createPS(temp.left, ps);
        ps.add(temp.value);
        createPS(temp.right, ps);
    }

    static int count = 1;

    private void modifyPSWithSum(Node temp, List<Integer> ps) {
        if (temp == null) {
            return;
        }

        modifyPSWithSum(temp.left, ps);
        temp.value = ps.get(count - 1) + ps.get(count + 1);
        count++;
        modifyPSWithSum(temp.right, ps);
    }

    public String inorder() {
        return traversal.inorder(root);
    }
}
