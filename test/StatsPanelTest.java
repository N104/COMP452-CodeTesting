import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsPanelTest {
    @Test
    void CalculateOrderedBinCountsTest() {
        GameStatsStub stats = new GameStatsStub(Map.of(
                1, 2,
                2, 4
        ));
        int[] counts = StatsPanel.calculateBinCounts(stats);
        assertEquals(2, counts[0]);
        assertEquals(4, counts[1]);
    }

    @Test
    void CalculateUnorderedBinCountsTest() {
        GameStatsStub stats = new GameStatsStub(Map.of(
                7, 4,
                3, 2
        ));
        int[] counts = StatsPanel.calculateBinCounts(stats);
        assertEquals(4, counts[3]);
        assertEquals(3, counts[1]);
    }
}
