package ds.hashing;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class HashTableUsingArray<K, V> {
    private List<Node<K, V>> buckets;
    // Represents current size
    private int size;
    // Represents max size
    private int numBuckets;

    public HashTableUsingArray() {
        buckets = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        range(0, 10).forEach(i -> buckets.add(null));
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        // Find the index
        int index = getBucketIndex(key);
        Node<K, V> head = buckets.get(index);

        while (head != null) {
            // Check all Nodes in the bucket
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public void add(K key, V value) {
        // Find the index at which key to be stored
        int index = getBucketIndex(key);
        Node<K, V> head = buckets.get(index);
        Node<K, V> temp = head;

        while (temp != null) {
            // Replace existing value if matched
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }

        // Increment size if key didn't exist
        ++size;

        Node<K, V> newNode = new Node<>(key, value);
        // Add newNode at beginning
        newNode.next = head;
        buckets.set(index, newNode);

        // Load factor consideration
        if ((1.0 * size) / numBuckets >= 0.7) {
            List<Node<K, V>> currentBuckets = buckets;
            buckets = new ArrayList<>();
            numBuckets *= 2;
            range(0, numBuckets).forEach(i -> buckets.add(null));

            // Add existing keys
            for (Node<K, V> node: currentBuckets) {
                while (node != null) {
                    // key's location may change
                    add(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    public V delete(K key) {
        // Find the index
        int index = getBucketIndex(key);
        Node<K, V> head = buckets.get(index);
        // To modify link after deleting the Node
        Node<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        // key not found
        if (head == null) {
            return null;
        }

        --size;

        if (prev != null) {
            // Deleted node is at middle or end
            prev.next = head.next;
        } else {
            // Deleted node is at beginning
            buckets.set(index, head.next);
        }

        return head.value;
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % numBuckets;
    }
}
