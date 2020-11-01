package ds.graph;

import java.util.LinkedList;

import static java.util.stream.IntStream.range;

public class Graph {
    public int v;
    public LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];

        range(0, v).forEach(i -> adj[i] = new LinkedList());
    }

    public void addEdge(int x, int y) {
        adj[x].add(y);
    }
}
