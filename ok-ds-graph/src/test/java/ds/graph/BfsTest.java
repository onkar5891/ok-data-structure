package ds.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BfsTest {
    @Test
    public void shouldPerformBfs() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        Bfs bfs = new Bfs(graph);
        assertEquals("2, 0, 3, 1", bfs.perform(2));
        assertEquals("3, 0, 1, 2", bfs.perform(3));
    }
}
