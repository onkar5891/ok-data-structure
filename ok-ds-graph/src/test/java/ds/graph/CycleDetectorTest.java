package ds.graph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CycleDetectorTest {
    @Test
    public void shouldDetectCycle() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        CycleDetector cd = new CycleDetector(g);
        assertTrue(cd.cycleExists());
    }

    @Test
    public void shouldNotDetectCycle() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        CycleDetector cd = new CycleDetector(g);
        assertFalse(cd.cycleExists());
    }
}
