package dp.knapsack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTabulationTest {
    @Test
    public void shouldFindMaxProfitableItems() {
        KnapsackTabulation k = new KnapsackTabulation();
        assertEquals(22, k.solveKnapsack(new int[] {1, 2, 3, 5}, new int[] {1, 6, 10, 16}, 7));
    }
}
