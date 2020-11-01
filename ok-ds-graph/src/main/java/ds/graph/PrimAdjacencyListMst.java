package ds.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class PrimAdjacencyListMst {
    private final Graph graph;

    public PrimAdjacencyListMst(Graph graph) {
        this.graph = graph;
    }

    private static class Node {
        private final int dest;
        private final int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

    }

    private static class HeapNode {
        private final int vertex;
        private int key;

        public HeapNode(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }

    public static class Graph {
        public int v;

        public LinkedList<Node>[] adj;

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            range(0, v).forEach(i -> adj[i] = new LinkedList<>());
        }

        public void addEdge(int u, int v, int weight) {
            adj[u].addLast(new Node(v, weight));
            adj[v].addLast(new Node(u, weight));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < v; i++) {
                sb.append(i).append(": ").append(Stream.of(adj[i]).flatMap(Collection::stream).map(n -> n.dest + "").collect(Collectors.joining(",")));
                sb.append("\n");
            }
            return sb.toString();
        }

    }

    public String mst() {
        // Storing visited vertex to prevent visiting again
        boolean[] mstSet = new boolean[graph.v];
        // As Prim's MST using adjacency list is implemented using MinHeap, we store all the graph nodes with infinite key (weight) initially
        HeapNode[] heapNodes = new HeapNode[graph.v];
        // Stores parent of i'th vertex at index i
        int[] parent = new int[graph.v];

        // Initialize heapNode key with max value and parents to -1
        for (int i = 0; i < graph.v; i++) {
            heapNodes[i] = new HeapNode(i, Integer.MAX_VALUE);
            parent[i] = -1;
        }

        // Mark the first node's key to 0 to be polled first from PriorityQueue
        heapNodes[0].key = 0;

        // TreeSet can also be used here to reduce remove() complexity, which is O(n) for PriorityQueue
        Queue<HeapNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.key));
        queue.addAll(Arrays.asList(heapNodes));

        while (!queue.isEmpty()) {
            // Poll the node with minimum key (weight)
            HeapNode heapNode = queue.poll();
            // Mark as visited
            mstSet[heapNode.vertex] = true;

            // For all adjacent nodes for the vertex polled from the queue
            for (Node node : graph.adj[heapNode.vertex]) {
                // If its not visited
                if (!mstSet[node.dest]) {
                    // If the key of adjacent vertex is greater than node's weight
                    if (heapNodes[node.dest].key > node.weight) {
                        // Remove the adjacent vertex (whose value is large)
                        queue.remove(heapNodes[node.dest]);
                        // Update the weight
                        heapNodes[node.dest].key = node.weight;
                        // Add it again to queue
                        queue.add(heapNodes[node.dest]);
                        // Mark the parent of adjacent vertex as heapNode's vertex (i.e. node.dest <-> heapNode.vertex edge will exist in MST)
                        parent[node.dest] = heapNode.vertex;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < graph.v; i++) {
            sb.append(parent[i]).append(" - ").append(i).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
