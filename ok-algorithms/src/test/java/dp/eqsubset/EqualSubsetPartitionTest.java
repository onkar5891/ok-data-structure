package dp.eqsubset;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualSubsetPartitionTest {
    @Test
    public void shouldFindIfSubsetCanBePartitionedEqually() {
        EqualSubsetPartition e = new EqualSubsetPartition();
        assertTrue(e.canPartition(new int[] {1, 2, 3, 4}));
        assertTrue(e.canPartition(new int[] {1, 1, 3, 4, 7}));
        assertFalse(e.canPartition(new int[] {2, 3, 4, 6}));
    }
}
