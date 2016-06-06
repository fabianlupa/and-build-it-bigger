package com.udacity.gradle.builditbigger;

import java.util.Random;

/**
 * Class to provide jokes
 */
public class JokeProvider {
    static final String[] JOKES = {
            // I am not very funny :/ ...
            "Joke 1",
            "Joke 2",
            "Joke 3",
            "Joke 4",
            "Joke 5",
            "Joke 6",
            "Joke 7",
            "Joke 8",
            "Joke 9",
            "Joke 10"
    };
    private final Random random = new Random(System.currentTimeMillis());

    public JokeProvider() {
    }

    /**
     * @return Random joke
     */
    public String getRandomJoke() {
        return JOKES[(int) (random.nextFloat() * JOKES.length)];
    }

    /**
     * Get a joke by its index
     *
     * @param index Index of the joke
     * @return Joke with specified index
     * @throws IndexOutOfBoundsException Joke with index does not exist
     */
    public String getJokeByIndex(int index) {
        if (index - 1 > JOKES.length) throw new IndexOutOfBoundsException();

        return JOKES[index];
    }
}
