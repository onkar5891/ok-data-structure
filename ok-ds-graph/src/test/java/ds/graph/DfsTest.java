package ds.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DfsTest {
    @Test
    public void shouldPerformDfs() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        Dfs dfs = new Dfs(graph);
        assertEquals("1, 2, 0, 3", dfs.perform(1));
        assertEquals("3, 0, 1, 2", dfs.perform(3));
    }
}
