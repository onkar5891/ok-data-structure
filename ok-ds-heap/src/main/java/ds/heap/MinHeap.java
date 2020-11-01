package ds.heap;

import java.util.Arrays;

public class MinHeap {
    final int[] arr;
    int capacity;
    int size;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    void insert(int key) {
        if (size == capacity) {
            System.err.println("Heap overflow..");
            return;
        }

        // Insert new key at the end (as Heap is a complete binary tree)
        int i = size;
        arr[i] = key;
        size++;

        // To preserve property of MinHeap, parent should be less that child
        // If this property violates at index i, swap values at parent(i) and i
        while (i != 0 && arr[parent(i)] > arr[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    void delete(int i) {
        // Decrease ith node value to -Inf so that it becomes the root
        decreaseKey(i, Integer.MIN_VALUE);
        // Extract the min, which removes the root element (-Inf in this case) and heapifies
        extractMin();
    }

    int[] elements() {
        return Arrays.copyOfRange(arr, 0, size);
    }

    void decreaseKey(int i, int newVal) {
        arr[i] = newVal;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    int extractMin() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            size--;
            return arr[0];
        }

        // Get the min
        int min = getMin();
        // Replace root with last value in heap
        arr[0] = arr[size - 1];
        size--;

        // Call heapify at index 0 (as it was modified) to preserve MinHeap property
        heapify(0);

        return min;
    }

    private void heapify(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;

        if (l < size && arr[l] < arr[i]) {
            smallest = l;
        }
        if (r < size && arr[r] < arr[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    int getMin() {
        return arr[0];
    }

    private void swap(int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private int leftChild(int i) {
        return i * 2 + 1;
    }

    private int rightChild(int i) {
        return i * 2 + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }
}
