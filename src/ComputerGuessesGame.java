public class ComputerGuessesGame {
    public static final int DEFAULT_INITIAL_UPPER_BOUND = 1000;
    public static final int DEFAULT_INITIAL_LOWER_BOUND = 1;

    private int numGuesses;
    private int lastGuess;

    // upperBound and lowerBound track the computer's knowledge about the correct number
    // They are updated after each guess is made
    private int upperBound; // correct number is <= upperBound
    private int lowerBound; // correct number is >= lowerBound

    private int initialUpperBound;
    private int initialLowerBound;

    ComputerGuessesGame() {
        this(DEFAULT_INITIAL_LOWER_BOUND, DEFAULT_INITIAL_UPPER_BOUND);
    }

    ComputerGuessesGame(int initialLowerBound, int initialUpperBound) {
        this.initialLowerBound = initialLowerBound;
        this.initialUpperBound = initialUpperBound;
        resetGame();
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getLastGuess() {
        return lastGuess;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public int getInitialUpperBound() {
        return initialUpperBound;
    }

    public int getInitialLowerBound() {
        return initialLowerBound;
    }

    public void guessLower() {
        upperBound = Math.min(upperBound, lastGuess);
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
    }

    public void guessHigher() {
        lowerBound = Math.max(lowerBound, lastGuess + 1);
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
    }

    public void resetGame() {
        numGuesses = 0;
        upperBound = initialUpperBound;
        lowerBound = initialLowerBound;
        lastGuess = (lowerBound + upperBound + 1) / 2;
    }
}
