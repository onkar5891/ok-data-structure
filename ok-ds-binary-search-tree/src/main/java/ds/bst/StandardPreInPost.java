package ds.bst;

public class StandardPreInPost {
    public String preorder(Node root) {
        StringBuilder sb = new StringBuilder();
        preorderInternal(sb, root);

        return sb.substring(0, sb.length() - 2);
    }

    public String inorder(Node root) {
        StringBuilder sb = new StringBuilder();
        inorderInternal(sb, root);

        return sb.substring(0, sb.length() - 2);
    }

    public String postorder(Node root) {
        StringBuilder sb = new StringBuilder();
        postorderInternal(sb, root);

        return sb.substring(0, sb.length() - 2);
    }

    private void postorderInternal(StringBuilder sb, Node temp) {
        if (temp != null) {
            postorderInternal(sb, temp.left);
            postorderInternal(sb, temp.right);
            sb.append(temp.value).append(", ");
        }
    }

    private void inorderInternal(StringBuilder sb, Node temp) {
        if (temp != null) {
            inorderInternal(sb, temp.left);
            sb.append(temp.value).append(", ");
            inorderInternal(sb, temp.right);
        }
    }

    private void preorderInternal(StringBuilder sb, Node temp) {
        if (temp != null) {
            sb.append(temp.value).append(", ");
            preorderInternal(sb, temp.left);
            preorderInternal(sb, temp.right);
        }
    }

}
