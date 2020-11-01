package ds.heap;

public class KthLargest {
    private final MinHeap minHeap;

    public KthLargest(int[] arr, int k) {
        minHeap = new MinHeap(k);

        for (int value : arr) {
            if (minHeap.size == k) {
                minHeap.extractMin();
            }
            minHeap.insert(value);
        }
    }

    public int add(int n) {
        int kthLargest = minHeap.getMin();
        if (n < kthLargest) {
            return kthLargest;
        }

        minHeap.extractMin();
        minHeap.insert(n);
        return minHeap.getMin();
    }
}
