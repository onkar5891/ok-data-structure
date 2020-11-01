package ds.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimArrayMstTest {
    @Test
    public void shouldFindMst() {
        int[][] graph = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };
        PrimArrayMst prim = new PrimArrayMst(graph);
        assertEquals("0 - 1, 1 - 2, 0 - 3, 1 - 4", prim.mst());
    }
}
