package com.udacity.gradle.builditbigger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class JokeProviderTest {
    private JokeProvider jokeProvider;

    @Before
    public void setUp() throws Exception {
        jokeProvider = new JokeProvider();
    }

    @After
    public void tearDown() throws Exception {
        jokeProvider = null;
    }

    @Test
    public void testGetRandomJoke() throws Exception {
        assertTrue(Arrays.asList(JokeProvider.JOKES).contains(jokeProvider.getRandomJoke()));
    }

    @Test
    public void testGetJokeByIndex() throws Exception {
        try {
            jokeProvider.getJokeByIndex(-1);
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }

        try {
            jokeProvider.getJokeByIndex(JokeProvider.JOKES.length);
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }

        for (int i = 0; i < JokeProvider.JOKES.length; i++)
            assertEquals(jokeProvider.getJokeByIndex(i), JokeProvider.JOKES[i]);
    }
}