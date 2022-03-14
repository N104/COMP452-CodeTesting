import java.util.Collections;
import java.util.Map;

public class GameStatsStub extends GameStats {
    private final Map<Integer, Integer> gameCounts; // num guesses -> num games

    GameStatsStub(Map<Integer, Integer> gameCounts) {
        this.gameCounts = gameCounts;
    }

    @Override
    public int numGames(int numGuesses) {
        return gameCounts.getOrDefault(numGuesses, 0);
    }

    @Override
    public int maxNumGuesses() {
        if (gameCounts.isEmpty()) {
            return 0;
        }
        return Collections.max(gameCounts.keySet());
    }
}
