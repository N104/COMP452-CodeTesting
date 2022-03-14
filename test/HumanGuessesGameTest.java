import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanGuessesGameTest {
    @Test
    void ConstructorTest() {
        RandomStub rnd = new RandomStub(233);
        HumanGuessesGame hgg = new HumanGuessesGame(rnd);
        assertEquals(234, hgg.getTarget());
        assertEquals(0, hgg.getNumGuesses());
        assertFalse(hgg.isDone());
    }

    @Test
    void GameOverTest() {
        RandomStub rnd = new RandomStub(233);
        HumanGuessesGame hgg = new HumanGuessesGame(rnd);
        hgg.makeGuess(234);
        assertTrue(hgg.isDone());
    }

    @Test
    void GuessCorrectTest() {
        RandomStub rnd = new RandomStub(233);
        HumanGuessesGame hgg = new HumanGuessesGame(rnd);
        assertEquals(GuessResult.CORRECT, hgg.makeGuess(234));
    }

    @Test
    void GuessAboveTest() {
        RandomStub rnd = new RandomStub(233);
        HumanGuessesGame hgg = new HumanGuessesGame(rnd);
        assertEquals(GuessResult.HIGH, hgg.makeGuess(235));
        assertEquals(GuessResult.HIGH, hgg.makeGuess(500));
    }

    @Test
    void GuessBelowTest() {
        RandomStub rnd = new RandomStub(233);
        HumanGuessesGame hgg = new HumanGuessesGame(rnd);
        assertEquals(GuessResult.LOW, hgg.makeGuess(233));
        assertEquals(GuessResult.LOW, hgg.makeGuess(100));
    }

    @Test
    void IncrementGuessesTest() {
        RandomStub rnd = new RandomStub(233);
        HumanGuessesGame hgg = new HumanGuessesGame(rnd);
        hgg.makeGuess(1);
        assertEquals(1, hgg.getNumGuesses());
        hgg.makeGuess(5);
        assertEquals(2, hgg.getNumGuesses());
    }

    @Test
    void GuessInvalidTest() {
        RandomStub rnd = new RandomStub(233);
        HumanGuessesGame hgg = new HumanGuessesGame(rnd);
        assertThrows(Exception.class, () -> hgg.makeGuess(0)); // below valid range
        assertThrows(Exception.class, () -> hgg.makeGuess(-1)); // negative value
        assertThrows(Exception.class, () -> hgg.makeGuess(HumanGuessesGame.UPPER_BOUND + 1)); // above valid range
    }

    @Test
    void MaxGuessTest() {
        RandomStub rnd = new RandomStub(233);
        HumanGuessesGame hgg = new HumanGuessesGame(rnd);
        assertDoesNotThrow(() -> hgg.makeGuess(HumanGuessesGame.UPPER_BOUND));
    }
}
