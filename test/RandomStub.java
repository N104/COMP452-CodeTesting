import java.util.Random;

public class RandomStub extends Random {
    private final int nextIntValue;

    RandomStub(int nextIntValue) {
        this.nextIntValue = nextIntValue;
    }

    @Override
    public int nextInt(int upperBound) {
        return nextIntValue;
    }
}
