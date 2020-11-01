package ds.graph;

import java.util.LinkedList;

import static java.util.Objects.nonNull;

public class CycleDetector {
    private final Graph g;

    public CycleDetector(Graph g) {
        this.g = g;
    }

    public boolean cycleExists() {
        boolean[] visited = new boolean[g.v];
        boolean[] recurred = new boolean[g.v];

        for (int i = 0; i < g.v; i++) {
            if (cycleExistsInternal(i, visited, recurred)) {
                return true;
            }
        }

        return false;
    }

    private boolean cycleExistsInternal(int u, boolean[] visited, boolean[] recurred) {
        if (recurred[u]) {
            return true;
        }

        if (!visited[u]) {
            visited[u] = recurred[u] = true;
            LinkedList<Integer> neighbours = g.adj[u];
            if (nonNull(neighbours)) {
                for (Integer neighbour : neighbours) {
                    if (cycleExistsInternal(neighbour, visited, recurred)) {
                        return true;
                    }
                }
            }
            recurred[u] = false;
        }

        return false;
    }
}
