package utils;

import java.util.Random;

public class RandomGenerator {
    private static RandomGenerator instance;
    private Random random;

    private RandomGenerator() {
        this.random = new Random();
    }

    public static RandomGenerator getInstance() {
        if (instance == null)
            instance = new RandomGenerator();
        return instance;
    }

    public double nextDouble() {
        return this.random.nextDouble();
    }
}
