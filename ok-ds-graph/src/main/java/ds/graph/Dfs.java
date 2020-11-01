package ds.graph;

import java.util.LinkedList;

import static java.util.Objects.nonNull;

public class Dfs {
    private final Graph graph;

    public Dfs(Graph graph) {
        this.graph = graph;
    }

    public String perform(int u) {
        boolean[] visited = new boolean[graph.v];
        StringBuilder sb = new StringBuilder();

        performRec(u, sb, visited);

        // Visit disconnected nodes from u
        for (int i = 0; i < graph.v; i++) {
            if (!visited[i]) {
                performRec(i, sb, visited);
            }
        }

        return sb.substring(0, sb.length() - 2);
    }

    private void performRec(int u, StringBuilder sb, boolean[] visited) {
        if (!visited[u]) {
            sb.append(u).append(", ");
            visited[u] = true;

            LinkedList<Integer> neighbours = graph.adj[u];
            if (nonNull(neighbours)) {
                for (Integer neighbour : neighbours) {
                    performRec(neighbour, sb, visited);
                }
            }
        }
    }
}
