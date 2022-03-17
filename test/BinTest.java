import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinTest {
    final int [] BIN_EDGES = {1, 2, 4, 6, 8, 10, 12, 14};

    @Test
    void CalculateFullSequencedBinCountsTest() {
        GameStatsStub stats = new GameStatsStub(Map.of(
                1, 2,
                2, 4,
                3, 7,
                4, 2,
                5,8,
                6,10,
                7, 2,
                8, 1
        ));
        int[] counts = Bin.calculateBinCounts(BIN_EDGES, stats);
        assertEquals(2, counts[0]);
        assertEquals(8, counts[1]);
        assertEquals(10, counts[2]);
        assertEquals(12, counts[3]);
        assertEquals(1, counts[4]);
        assertEquals(0, counts[5]);
        assertEquals(0, counts[6]);
        assertEquals(0, counts[7]);
    }

    @Test
    void CalculatePartialSequencedBinCountsTest() {
        GameStatsStub stats = new GameStatsStub(Map.of(
                4, 2,
                5,8,
                6,10,
                7, 2
        ));
        int[] counts = Bin.calculateBinCounts(BIN_EDGES, stats);
        assertEquals(0, counts[0]);
        assertEquals(0, counts[1]);
        assertEquals(10, counts[2]);
        assertEquals(12, counts[3]);
        assertEquals(0, counts[4]);
        assertEquals(0, counts[5]);
        assertEquals(0, counts[6]);
        assertEquals(0, counts[7]);
    }

    @Test
    void CalculateUnorderedBinCountsTest() {
        GameStatsStub stats = new GameStatsStub(Map.of(
                7, 4,
                3, 2,
                5, 3
        ));
        int[] counts = Bin.calculateBinCounts(BIN_EDGES, stats);
        assertEquals(4, counts[3]);
        assertEquals(3,counts[2]);
        assertEquals(2, counts[1]);
        assertEquals(0, counts[0]);
        assertEquals(0, counts[4]);
        assertEquals(0, counts[5]);
        assertEquals(0, counts[6]);
        assertEquals(0, counts[7]);
    }

    void CalculateGappedBinCountsTest() {
        GameStatsStub stats = new GameStatsStub(Map.of(
                2, 4,
                3, 7,
                5,8,
                8, 1,
                12, 3,
                14, 1,
                16, 4
        ));
        int[] counts = Bin.calculateBinCounts(BIN_EDGES, stats);
        assertEquals(0, counts[0]);
        assertEquals(11, counts[1]);
        assertEquals(8, counts[2]);
        assertEquals(0, counts[3]);
        assertEquals(1, counts[4]);
        assertEquals(0, counts[5]);
        assertEquals(3, counts[6]);
        assertEquals(5, counts[7]);
    }

    @Test
    void CalculateHighValuesOnly() {
        GameStatsStub stats = new GameStatsStub(Map.of(
                16, 2,
                18, 4,
                10000, 1
        ));
        int[] counts = Bin.calculateBinCounts(BIN_EDGES, stats);
        assertEquals(0, counts[0]);
        assertEquals(0, counts[1]);
        assertEquals(0, counts[2]);
        assertEquals(0, counts[3]);
        assertEquals(0, counts[4]);
        assertEquals(0, counts[5]);
        assertEquals(0, counts[6]);
        assertEquals(7, counts[7]);
    }

    @Test
    void CalculateLowerValuesOnly() {
        GameStatsStub stats = new GameStatsStub(Map.of(
                1, 2,
                2, 4
        ));
        int[] counts = Bin.calculateBinCounts(BIN_EDGES, stats);
        assertEquals(2, counts[0]);
        assertEquals(4, counts[1]);
        assertEquals(0, counts[2]);
        assertEquals(0, counts[3]);
        assertEquals(0, counts[4]);
        assertEquals(0, counts[5]);
        assertEquals(0, counts[6]);
        assertEquals(0, counts[7]);
    }

    @Test
    void CalculateBinCountsInvalidInputs() {
        GameStatsStub stats = new GameStatsStub(Map.of(
                0, 2
        ));
        assertThrows(Exception.class, () -> Bin.calculateBinCounts(BIN_EDGES, stats));
        GameStatsStub stats2 = new GameStatsStub(Map.of(
                -17, 5
        ));
        assertThrows(Exception.class, () -> Bin.calculateBinCounts(BIN_EDGES, stats2));
        GameStatsStub stats3 = new GameStatsStub(Map.of(
                1, -7
        ));
        assertThrows(Exception.class, () -> Bin.calculateBinCounts(BIN_EDGES, stats3));
    }

    @Test
    void GetBinNameTest() {
        assertEquals("1", Bin.getBinName(BIN_EDGES, 0));
        assertEquals("2-3", Bin.getBinName(BIN_EDGES, 1));
        assertEquals("6-7", Bin.getBinName(BIN_EDGES, 3));
        assertEquals("14 or more", Bin.getBinName(BIN_EDGES, 7));
    }

    @Test
    void InvalidBinInputs() {
        assertThrows(Exception.class, () -> Bin.getBinName(BIN_EDGES, 8)); // above valid range
        assertThrows(Exception.class, () -> Bin.getBinName(BIN_EDGES, -5)); // below valid range
    }
}
