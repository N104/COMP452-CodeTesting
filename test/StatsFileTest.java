import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

public class StatsFileTest {
    @Test
    void validCsvParsing() {
        StatsFile sf = new StatsFile();
        LocalDateTime limit = LocalDateTime.parse("2022-02-25T00:00:00.000000000");
        String[] values = {"2022-02-25T21:56:20.574164900","12"};
        assertDoesNotThrow(() -> sf.csvParsing(values, sf.getMap(), limit));
        String[] values2 = {"2022-02-25T09:42:16.641646300","7"};
        assertDoesNotThrow(() -> sf.csvParsing(values2, sf.getMap(), limit));
        String[] values3 = {"2022-02-25T09:42:40.369156","1"};
        assertDoesNotThrow(() -> sf.csvParsing(values3, sf.getMap(), limit));
        String[] values4 = {"2022-02-25T10:40:10.642281400", String.valueOf(Integer.MAX_VALUE)};
        assertDoesNotThrow(() -> sf.csvParsing(values4, sf.getMap(), limit));
    }

    @Test
    void invalidNumberCsvParsing() {
        StatsFile sf = new StatsFile();
        LocalDateTime limit = LocalDateTime.parse("2022-02-25T00:00:00.000000000");
        String[] values = {"2022-02-25T21:56:20.574164900","J"};
        assertThrows(NumberFormatException.class, () -> sf.csvParsing(values, sf.getMap(), limit));
        String[] values2 = {"2022-02-25T21:56:20.574164900","25^8"};
        assertThrows(NumberFormatException.class, () -> sf.csvParsing(values2, sf.getMap(), limit));
    }

    @Test
    void invalidDateTimeCsvParsing() {
        StatsFile sf = new StatsFile();
        LocalDateTime limit = LocalDateTime.parse("2022-02-25T00:00:00.000000000");
        String[] values = {"202T-02-25T21:56:20.574164900","12"};
        assertThrows(DateTimeParseException.class, () -> sf.csvParsing(values, sf.getMap(), limit));
        String[] values2 = {"0","12"};
        assertThrows(DateTimeParseException.class, () -> sf.csvParsing(values2, sf.getMap(), limit));
    }
}
