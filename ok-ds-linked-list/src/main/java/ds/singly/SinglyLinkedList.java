package ds.singly;

public class SinglyLinkedList {
    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + value + '}';
        }
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node todo = head.next;
        Node reversed = head;
        reversed.next = null;

        while (todo != null) {
            Node cur = todo;
            todo = todo.next;

            cur.next = reversed;
            reversed = cur;
        }

        head = reversed;
    }

    public void insertAtBeginning(int v) {
        if (head == null) {
            head = new Node(v);
            return;
        }

        Node node = new Node(v);
        node.next = head;
        head = node;
    }

    public void insertAt(int location, int v) {
        if (location == 1) {
            insertAtBeginning(v);
            return;
        }

        Node temp = head;
        int i = 1;
        while (i < location - 1 && temp != null) {
            i++;
            temp = temp.next;
        }

        if (temp == null) {
            System.err.println("Invalid location..");
            return;
        }

        Node node = new Node(v);
        node.next = temp.next;
        temp.next = node;
    }

    public void append(int v) {
        if (head == null) {
            head = new Node(v);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(v);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            sb.append(temp.value).append(", ");
            temp = temp.next;
        }
        return sb.substring(0, sb.length() - 2);
    }
}
