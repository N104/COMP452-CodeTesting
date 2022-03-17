import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerGuessesGameTest {
    @Test
    void ConstructorTest() {
        ComputerGuessesGame game = new ComputerGuessesGame(1, 1000);
        assertEquals(0, game.getNumGuesses());
        assertEquals(1, game.getLowerBound());
        assertEquals(1000, game.getUpperBound());
        assertEquals(500, game.getLastGuess());
    }

    @Test
    void ConstructorDefaultsTest() {
        ComputerGuessesGame game = new ComputerGuessesGame();
        assertEquals(ComputerGuessesGame.DEFAULT_INITIAL_LOWER_BOUND, game.getInitialLowerBound());
        assertEquals(ComputerGuessesGame.DEFAULT_INITIAL_UPPER_BOUND, game.getInitialUpperBound());
        assertEquals(ComputerGuessesGame.DEFAULT_INITIAL_LOWER_BOUND, game.getLowerBound());
        assertEquals(ComputerGuessesGame.DEFAULT_INITIAL_UPPER_BOUND, game.getUpperBound());
        assertEquals(0, game.getNumGuesses());
    }

    @Test
    void GuessLowerTest() {
        // the number we picked for the computer to guess is 1
        ComputerGuessesGame game = new ComputerGuessesGame(1, 1000);
        assertEquals(500, game.getLastGuess());
        game.guessLower();
        assertEquals(250, game.getLastGuess());
        game.guessLower();
        assertEquals(125, game.getLastGuess());
        game.guessLower();
        assertEquals(63, game.getLastGuess());
        game.guessLower();
        assertEquals(32, game.getLastGuess());
        game.guessLower();
        assertEquals(16, game.getLastGuess());
        game.guessLower();
        assertEquals(8, game.getLastGuess());
        game.guessLower();
        assertEquals(4, game.getLastGuess());
        game.guessLower();
        assertEquals(2, game.getLastGuess());
        game.guessLower();
        assertEquals(1, game.getLastGuess());
    }
    @Test
    void GuessHigherTest() {
        // the number we picked for the computer to guess is 1000
        ComputerGuessesGame game = new ComputerGuessesGame(1, 1000);
        assertEquals(500, game.getLastGuess());
        game.guessHigher();
        assertEquals(751, game.getLastGuess());
        game.guessHigher();
        assertEquals(876, game.getLastGuess());
        game.guessHigher();
        assertEquals(939, game.getLastGuess());
        game.guessHigher();
        assertEquals(970, game.getLastGuess());
        game.guessHigher();
        assertEquals(986, game.getLastGuess());
        game.guessHigher();
        assertEquals(994, game.getLastGuess());
        game.guessHigher();
        assertEquals(998, game.getLastGuess());
        game.guessHigher();
        assertEquals(1000, game.getLastGuess());
    }

    @Test void ResetGameTest() {
        ComputerGuessesGame game = new ComputerGuessesGame(1, 500);
        game.guessLower();
        game.guessHigher();
        game.resetGame();
        assertEquals(0, game.getNumGuesses());
        assertEquals(1, game.getLowerBound());
        assertEquals(500, game.getUpperBound());
        assertEquals(250, game.getLastGuess());
    }

    @Test void ResetDefaultGameTest() {
        ComputerGuessesGame game = new ComputerGuessesGame();
        game.guessLower();
        game.guessHigher();
        game.resetGame();
        assertEquals(0, game.getNumGuesses());
        assertEquals(ComputerGuessesGame.DEFAULT_INITIAL_LOWER_BOUND, game.getLowerBound());
        assertEquals(ComputerGuessesGame.DEFAULT_INITIAL_UPPER_BOUND, game.getUpperBound());
    }
}
