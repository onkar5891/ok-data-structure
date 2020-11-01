package ds.graph;

public class PrimArrayMst {
    private final int[][] graph;
    private final int v;

    public PrimArrayMst(int[][] graph) {
        this.graph = graph;
        this.v = graph.length;
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < v; i++) {
            if (!mstSet[i] && min > key[i]) {
                min = key[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    String mst() {
        boolean[] mstSet = new boolean[v];
        int[] parent = new int[v];
        int[] key = new int[v];

        for (int i = 0; i < v; i++) {
            parent[i] = -1;
            key[i] = Integer.MAX_VALUE;
        }

        key[0] = 0;
        for (int i = 0; i < v - 1; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int j = 0; j < v; j++) {
                if (!mstSet[j] && graph[u][j] != 0 && key[j] > graph[u][j]) {
                    key[j] = graph[u][j];
                    parent[j] = u;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < v; i++) {
            sb.append(parent[i]).append(" - ").append(i).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
