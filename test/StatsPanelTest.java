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
                3, 2,
                5, 3
        ));
        int[] counts = StatsPanel.calculateBinCounts(stats);
        assertEquals(4, counts[3]);
        assertEquals(3,counts[2]);
        assertEquals(2, counts[1]);
    }
    @Test
    void CalculateHighValues() {
        GameStatsStub stats = new GameStatsStub(Map.of(
                16, 2,
                18, 4
        ));
        int[] counts = StatsPanel.calculateBinCounts(stats);
        assertEquals(6, counts[7]);
    }
}
