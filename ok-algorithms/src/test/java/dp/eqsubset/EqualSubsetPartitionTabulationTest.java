package dp.eqsubset;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualSubsetPartitionTabulationTest {
    @Test
    public void shouldFindIfSubsetCanBePartitionedEqually() {
        EqualSubsetPartitionTabulation e = new EqualSubsetPartitionTabulation();
        assertFalse(e.canPartition(new int[] {2}));
        assertTrue(e.canPartition(new int[] {1, 2, 3, 4}));
        assertTrue(e.canPartition(new int[] {1, 1, 3, 4, 7}));
        assertFalse(e.canPartition(new int[] {2, 3, 4, 6}));
    }
}
