package ds.graph;

import java.util.LinkedList;
import java.util.Queue;

import static java.util.Objects.nonNull;

public class Bfs {
    private final Graph graph;

    public Bfs(Graph graph) {
        this.graph = graph;
    }

    public String perform(int u) {
        boolean[] visited = new boolean[graph.v];
        StringBuilder sb = new StringBuilder();

        bfs(u, sb, visited);

        // Visit disconnected nodes from u
        for (int i = 0; i < graph.v; i++) {
            if (!visited[i]) {
                bfs(i, sb, visited);
            }
        }

        return sb.substring(0, sb.length() - 2);
    }

    // Complexity: O(V+E) - V: no. of vertices, E: no. of edges
    public void bfs(int u, StringBuilder sb, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (!visited[node]) {
                sb.append(node).append(", ");

                LinkedList<Integer> neighbours = graph.adj[node];
                if (nonNull(neighbours)) {
                    queue.addAll(neighbours);
                }

                visited[node] = true;
            }
        }
    }
}
